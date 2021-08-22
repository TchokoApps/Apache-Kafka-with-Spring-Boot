package com.tchokoapps.springboot.kafka.springkafkaboot;

import com.tchokoapps.springboot.kafka.springkafkaboot.configs.Config;
import com.tchokoapps.springboot.kafka.springkafkaboot.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@Slf4j
@SpringBootApplication
public class SpringKafkaBootApplication implements CommandLineRunner {

    private KafkaProducer kafkaProducer;
    private Config config;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        kafkaProducer.send(config.getTopic(),"Hello World");
    }
}
