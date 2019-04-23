package com.bqniu.kafkademo.consumer;

import com.bqniu.kafkademo.common.Bar;
import com.bqniu.kafkademo.common.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(id = "multiGroup3", topics = { "foos", "bars" })
public class MultiGroupConsumer3 {
    @KafkaHandler
    public void foo(Foo foo) {
        log.info("Consumer3 Received: " + foo);
    }

    @KafkaHandler
    public void bar(Bar bar) {
        log.info("Consumer3 Received: " + bar);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        log.info("Consumer3 Received unknown: " + object);
    }
}
