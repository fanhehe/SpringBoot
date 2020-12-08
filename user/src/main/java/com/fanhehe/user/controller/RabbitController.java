package com.fanhehe.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    static {
        executorService.submit(() -> {
            try {
                while(true) {
                    logger.info("==========>");
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (Exception e) {
                logger.error("异常", e);
            }
        });
    }

    @GetMapping("/")
    public String index() {

        logger.info("sssss");
        logger.error("fafdsfasfasdfsf");

        rabbitTemplate.convertAndSend("user.login", "fannnnnnnnnnnnnnnnnnnnnnnnn");

        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (Exception e) {
            logger.error("sleep => ", e);
        }

        return "3213212";
    }

    @RabbitListener(queues= "test-user", ackMode = "MANUAL")
    public void userLogin(Message message, Channel channel) {
        try {
            String type = message.toString();
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
            }
        } finally {

        }
    }
}
