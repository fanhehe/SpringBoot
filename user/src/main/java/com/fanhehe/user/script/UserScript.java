package com.fanhehe.user.script;

import com.fanhehe.user.pojo.PO.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

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
