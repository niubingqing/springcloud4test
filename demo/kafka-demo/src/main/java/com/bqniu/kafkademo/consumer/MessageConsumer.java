package com.bqniu.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.awt.*;

@Slf4j
@Component
public class MessageConsumer {
    @KafkaListener(topics = "app_log", groupId = "applog")
    public void processMessage(String content) {
        log.info("Received app log:" + content.toString());
    }

    @KafkaListener(topics = "topic2", groupId = "applog")
    public void processMessage1(String content) {
        log.info("Received topic2:" + content.toString());
    }
}
