package com.tchokoapps.springboot.kafka.springkafkaboot.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class KafkaConsumer {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info("Message received: {}", consumerRecord);
        countDownLatch.countDown();
    }
}
