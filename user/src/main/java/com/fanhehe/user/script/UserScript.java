package com.fanhehe.user.script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fanhehe.user.pojo.PO.User;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class UserScript {

    private static final Logger logger = LoggerFactory.getLogger(UserScript.class);

    @RabbitListener(queues = "user")
    public void handle1(User user) {
        logger.info(user.toString() + "1");
    }

    @RabbitListener(queues = "user_2")
    public void handle2(User user) {
        logger.info(user.toString() + "2");
    }
}
