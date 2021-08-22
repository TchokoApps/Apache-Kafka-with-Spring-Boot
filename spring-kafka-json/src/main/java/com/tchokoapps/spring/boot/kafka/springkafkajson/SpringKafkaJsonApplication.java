package com.tchokoapps.spring.boot.kafka.springkafkajson;

import com.tchokoapps.spring.boot.kafka.springkafkajson.kafka.producer.KafkaProducer;
import com.tchokoapps.spring.boot.kafka.springkafkajson.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@AllArgsConstructor
@SpringBootApplication
public class SpringKafkaJsonApplication implements CommandLineRunner {

    KafkaProducer kafkaProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaJsonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = Employee.builder()
                .id(new Random().nextInt())
                .firstName("Alain")
                .lastName("Tchokonte")
                .age(20)
                .build();
        kafkaProducer.send(employee);
    }
}
