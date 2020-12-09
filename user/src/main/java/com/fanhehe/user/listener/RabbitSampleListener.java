package com.fanhehe.user.listener;

import java.util.Arrays;
import org.slf4j.Logger;
import lombok.SneakyThrows;
import org.slf4j.LoggerFactory;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/11/12 11:31
 */
@RestController
public class RabbitSampleListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RabbitSampleListener.class);

    @Service
    public static class RabbitSampleConfig {
        @Bean
        @Qualifier(RabbitmqConstant.PROGRAMMATICALLY_QUEUE)
        org.springframework.amqp.core.Queue queue() {
            return new org.springframework.amqp.core.Queue(RabbitmqConstant.PROGRAMMATICALLY_QUEUE, false, false, true);
        }

        @Bean
        @Qualifier(RabbitmqConstant.PROGRAMMATICALLY_EXCHANGE)
        TopicExchange exchange() {
            return new TopicExchange(RabbitmqConstant.PROGRAMMATICALLY_EXCHANGE, false, true);
        }

        @Bean
        Binding binding(@Qualifier(RabbitmqConstant.PROGRAMMATICALLY_EXCHANGE) TopicExchange exchange,
                        @Qualifier(RabbitmqConstant.PROGRAMMATICALLY_QUEUE) org.springframework.amqp.core.Queue queue) {
            return BindingBuilder.bind(queue).to(exchange).with(RabbitmqConstant.PROGRAMMATICALLY_KEY);
        }

        @Bean
        SimpleMessageListenerContainer simpleContainer(ConnectionFactory connectionFactory) {
            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.setMessageListener(message -> logger.info("simple receiver,message:{}", message));
            container.setQueueNames(RabbitmqConstant.PROGRAMMATICALLY_QUEUE);
            return container;
        }

        @Bean
        ConnectionFactory connectionFactory(@Value("${spring.rabbitmq.port}") int port,
                                            @Value("${spring.rabbitmq.host}") String host,
                                            @Value("${spring.rabbitmq.username}") String userName,
                                            @Value("${spring.rabbitmq.password}") String password,
                                            @Value("${spring.rabbitmq.virtual-host}") String vhost) {
            CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
            connectionFactory.setHost(host);
            connectionFactory.setPort(port);
            connectionFactory.setVirtualHost(vhost);
            connectionFactory.setUsername(userName);
            connectionFactory.setPassword(password);
            return connectionFactory;
        }

        public static final class RabbitmqConstant {
            public static final String PROGRAMMATICALLY_QUEUE = "PROGRAMMATICALLY_QUEUE";
            public static final String PROGRAMMATICALLY_EXCHANGE = "PROGRAMMATICALLY_EXCHANGE";
            public static final String PROGRAMMATICALLY_KEY = "PROGRAMMATICALLY_KEY";
        }
    }


    @GetMapping("/rabbit-mq")
    public String rabbitmq() {
        rabbitTemplate.convertAndSend("zhihao.miao.exchange", "q5", "nnnnnnn");
        return "3213212";
    }

    @GetMapping("/rabbit-mq-batch")
    public String rabbitmqBatch() {
        rabbitTemplate.convertAndSend("zhihao.miao.exchange", "q5", "nnnnnnn");
        return "3213212";
    }

    /**
     * 支持自动声明绑定，声明之后自动监听队列的队列，此时@RabbitListener注解的queue和bindings不能同时指定，否则报错
     * @param message 消息体
     */
    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            key = "welcome",
                            value = @Queue(value = "q5", durable = "true"),
                            exchange = @Exchange(value = "zhihao.miao.exchange")
                    ),
            },
            ackMode = "MANUAL",
            concurrency = "4",
            containerFactory = "rabbitListenerContainerFactory"
    )
    @SneakyThrows
    public void handleMessage(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG)long deliveryTag, @Payload String payload) {
        try {
            System.out.println("====消费消息" + message.getMessageProperties().getConsumerQueue() + "===");
            System.out.println(message.getMessageProperties());
            System.out.println(new String(message.getBody()));

            assert Arrays.toString(message.getBody()).equals(payload);
            assert deliveryTag == message.getMessageProperties().getDeliveryTag();
            // 方法的第二个参数 multiple 取值为 false 时，表示通知 RabbitMQ 当前消息被确认
            // 如果为 true，则额外将比第一个参数指定的deliveryTag 小的消息一并确认。
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            logger.error("异常: ", e);
            // baseNack第二个参数 表示需要尽量将这条消息投递给其他的消费者重新消费, 表示这个消息会重新进入队列重新消费
            // 第三个参数代表是否要重新入队
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
