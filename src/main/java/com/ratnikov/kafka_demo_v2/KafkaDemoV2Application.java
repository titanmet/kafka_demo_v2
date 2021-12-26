package com.ratnikov.kafka_demo_v2;

import com.ratnikov.kafka_demo_v2.model.UserDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class KafkaDemoV2Application {

    @KafkaListener(topics = "msg")
    public void msgListener(ConsumerRecord<Long, UserDto> record) {
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoV2Application.class, args);
    }

}
