package com.fanhehe.user.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author fanhehe
 */
@Aspect
@Component
public class ControllerAop {

    ControllerAop() {
        logger.info("xxxxx");
    }

    private static Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    @Pointcut("within(com.fanhehe.user.listener.*)")
    public void handleLog() {
    }

    @Before("handleLog()")
    public void handlePrint() {
        logger.info("====================");
    }
}
