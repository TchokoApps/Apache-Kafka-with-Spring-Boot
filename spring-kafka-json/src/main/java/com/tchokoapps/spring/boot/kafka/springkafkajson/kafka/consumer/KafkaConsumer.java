package com.tchokoapps.spring.boot.kafka.springkafkajson.kafka.consumer;

import com.tchokoapps.spring.boot.kafka.springkafkajson.model.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Component
public class KafkaConsumer {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void receive(Employee employee) {
        log.info("Received message: {} succeeded", employee);
        countDownLatch.countDown();
    }
}
