package com.bqniu.rabbitmq.controller;

import com.bqniu.rabbitmq.config.MqQueueInfoConfig;
import com.bqniu.rabbitmq.dataobject.Message;
import com.bqniu.rabbitmq.producer.ClientWayMsgProducer;
import com.bqniu.rabbitmq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private ClientWayMsgProducer producer;

    @Autowired
    private MqQueueInfoConfig mqQueueInfoConfig;

    @PostMapping
    public void sendMessage(@RequestBody Object obj) {
        messageProducer.sendMessage("123456");
    }

    @PostMapping("/send1")
    public void sendMessage1(@RequestBody Message obj) {
        messageProducer.sendMessage(obj);
    }

    @PostMapping("/send2")
    public void sendMessage2() {
        messageProducer.sendMessage2Exchange("123456");
    }

    @PostMapping("/send3")
    public  void sendMessage3(@RequestBody Message obj){
        messageProducer.sendMessageWithCallback(obj);
    }

    @GetMapping
    public String getMessage() {
        return mqQueueInfoConfig.getTestqueue2();
    }

    @PostMapping("/send")
    public void sendMessage4() {
        producer.sendMsg("123456");
    }
}
