package com.tchokoapps.springboot.kafka.springkafkaboot.configs;

import lombok.Getter;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Getter
@Configuration
public class Config {

    @Value("${spring.kafka.template.default-topic}")
    public String topic;

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(topic).partitions(2).replicas(1).build();
    }
}
