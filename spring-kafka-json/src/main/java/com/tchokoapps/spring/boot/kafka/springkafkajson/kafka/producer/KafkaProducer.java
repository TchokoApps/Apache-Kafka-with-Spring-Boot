package com.tchokoapps.spring.boot.kafka.springkafkajson.kafka.producer;

import com.tchokoapps.spring.boot.kafka.springkafkajson.configs.Config;
import com.tchokoapps.spring.boot.kafka.springkafkajson.model.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@AllArgsConstructor
@Component
public class KafkaProducer {

    private KafkaTemplate<String, Employee> kafkaTemplate;
    private Config config;

    public void send(Employee employee) {
        kafkaTemplate.send(config.getTopic(),employee).addCallback(new ListenableFutureCallback<SendResult<String, Employee>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Failed to send message: {}", throwable.toString());
            }

            @Override
            public void onSuccess(SendResult<String, Employee> stringEmployeeSendResult) {
                log.info("Send message {} succeeded",stringEmployeeSendResult.getProducerRecord().value());
            }
        });

    }
}
