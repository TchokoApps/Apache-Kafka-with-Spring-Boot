package com.tchokoapps.spring.boot.kafka.springkafkajson.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class Config {

    @Value("${spring.kafka.template.default-topic}")
    private String topic;
}
