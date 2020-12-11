package com.fanhehe.user.business.test.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/11/22 08:42
 */
@RestController
public class KafkaSampleListener {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaSampleListener.class);

    @GetMapping("/kafkas")
    public String kafkaHelloWorld() {
        kafkaTemplate.send("kafka", "xxxxxxxxx");
        return "SUCCESS";
    }

    @KafkaListener(id = "s1", topics = "kafka")
    public void queueCallbackS1(ConsumerRecord record, Acknowledgment acknowledgment) {
        record.value();
        acknowledgment.acknowledge();

        logger.info("s1 =======================> {}", record.value());
    }

    @KafkaListener(id = "s2", topics = "kafka")
    public void queueCallbackS2(ConsumerRecord record, Acknowledgment acknowledgment) {
        record.value();
        acknowledgment.acknowledge();
        logger.info("s2 =======================> {}", record.value());
    }
}
