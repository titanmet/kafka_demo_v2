package com.ratnikov.kafka_demo_v2.controller;

import com.ratnikov.kafka_demo_v2.model.Address;
import com.ratnikov.kafka_demo_v2.model.UserDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MessageController {

    private KafkaTemplate<Long, UserDto> kafkaTemplate;

    public MessageController(KafkaTemplate<Long, UserDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void sendMsg(Long msgId, UserDto msg) {
        msg.setAddress(new Address("Rus","Rnd","Lenina",1L,1L));
        ListenableFuture<SendResult<Long, UserDto>> future = kafkaTemplate.send("msg", msgId, msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }

}
