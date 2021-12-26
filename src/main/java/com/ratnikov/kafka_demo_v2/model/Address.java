package com.ratnikov.kafka_demo_v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private String street;
    private Long homeNumber;
    private Long flatNumber;
}
