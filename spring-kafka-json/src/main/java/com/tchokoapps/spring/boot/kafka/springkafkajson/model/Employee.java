package com.tchokoapps.spring.boot.kafka.springkafkajson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
