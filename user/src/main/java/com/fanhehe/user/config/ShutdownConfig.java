package com.fanhehe.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.catalina.connector.Connector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/2 08:46
 */
@Configuration
public class ShutdownConfig {

    public GracefulShutdown gracefulShutdown() {
        return new GracefulShutdown();
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(gracefulShutdown());
        return tomcat;
    }

    private static class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {

        private final int waitTime = 120;
        private volatile Connector connector;
        private static final Logger logger = LoggerFactory.getLogger(GracefulShutdown.class);

        @Override
        public void customize(Connector connector) {
            this.connector = connector;
        }

        @Override
        public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
            this.connector.pause();
            Executor executor = this.connector.getProtocolHandler().getExecutor();
            if (executor instanceof ThreadPoolExecutor) {
                try {

                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                    logger.info("shutdown start");
                    threadPoolExecutor.shutdown();
                    logger.info("shutdown end");
                    if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
                        logger.info("Tomcat 进程在" + waitTime + "秒内无法结束，尝试强制结束");
                    }
                    logger.info("shutdown success");
                } catch (InterruptedException ex) {
                    logger.error("异常: ", ex);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
