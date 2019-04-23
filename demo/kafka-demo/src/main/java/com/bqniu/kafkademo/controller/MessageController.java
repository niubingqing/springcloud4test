package com.bqniu.kafkademo.controller;

import com.bqniu.kafkademo.producer.TransKafkaClientProducer;
import com.bqniu.kafkademo.producer.TransMessageProducer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/msg")
@RestController
public class MessageController {

//    @Autowired
//    private TransKafkaClientProducer producer;

    @Autowired
    private TransMessageProducer transMessageProducer;

    @GetMapping("/send")
    public void sendMessage() {
        ArrayList<String> obj = new ArrayList<String>(
                Arrays.asList("abc", "def", "ghj"));
        transMessageProducer.sendMessage(obj);
    }

    @GetMapping("/send2")
    public void getConsumerRecords() throws Exception {
        ArrayList<String> obj = new ArrayList<String>(
                Arrays.asList("abc", "def", "ghj"));
        transMessageProducer.sendMessage2(obj);
    }
}
