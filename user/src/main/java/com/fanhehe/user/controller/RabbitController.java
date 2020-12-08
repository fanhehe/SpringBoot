package com.fanhehe.user.controller;

import lombok.SneakyThrows;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/11/12 11:31
 */
@RestController
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RabbitController.class);

    @GetMapping("/")
    public String index() {
        rabbitTemplate.convertAndSend("user.login", "fannnnnnnnnnnnnnnnnnnnnnnnn");
        return "3213212";
    }

    @SneakyThrows
    @RabbitListener(queues= "test-user", ackMode = "MANUAL")
    public void userLogin(Message message, Channel channel) {
        String type = message.toString();
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
    }
}
