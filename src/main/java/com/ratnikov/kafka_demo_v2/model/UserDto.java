package com.ratnikov.kafka_demo_v2.model;

import lombok.Data;

@Data
public class UserDto {
    private Long age;
    private String name;
    private Address address;
}
