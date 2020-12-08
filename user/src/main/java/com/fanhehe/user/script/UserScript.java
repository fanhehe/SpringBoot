package com.fanhehe.user.script;

import com.fanhehe.user.pojo.PO.User;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author fanhehe
 */
@Component
public class UserScript {

    private static final Logger logger = LoggerFactory.getLogger(UserScript.class);

    @RabbitListener(queues = {"user", "users"})
    public void handle1(@Payload User user, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws Exception {
        logger.info(user.toString() + "1");
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = "user_2")
    public void handle2(User user) {
        logger.info(user.toString() + "2");
    }
}
