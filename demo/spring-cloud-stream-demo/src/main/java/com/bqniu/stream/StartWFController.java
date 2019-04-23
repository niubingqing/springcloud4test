package com.bqniu.stream;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wf")
public class StartWFController {

//    @Autowired
//    private StreamClient streamClient;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/start")
    public void startWF(){
        amqpTemplate.convertAndSend("sample1-in","start","wake up!!!");
        //streamClient.output().send(MessageBuilder.withPayload("wake up!!!").build());
    }

}
