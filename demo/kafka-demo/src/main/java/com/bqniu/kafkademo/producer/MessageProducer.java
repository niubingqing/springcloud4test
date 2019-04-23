package com.bqniu.kafkademo.producer;

import com.bqniu.kafkademo.common.Bar;
import com.bqniu.kafkademo.common.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Slf4j
@Component
@EnableScheduling
public class MessageProducer {
    @Autowired
    KafkaTemplate kafkaTemplate;

//    @Scheduled(cron = "00/5 * * * * ?")
//    public void sendMessage(){
//        String message = UUID.randomUUID().toString();
//        ListenableFuture future = kafkaTemplate.send("app_log", message);
//        future.addCallback(o -> log.info("send-消息发送成功：" + message), throwable -> log.error(("消息发送失败：" + message)));
//    }

//    @Scheduled(cron = "00/5 * * * * ?")
//    public void sendFooMessage(){
//        String message="HelloWorld,Foo";
//        ListenableFuture future = kafkaTemplate.send("foos", new Foo(message));
//        future.addCallback(o -> log.info("send-消息发送成功：" + message), throwable -> log.error(("消息发送失败：" + message)));
//    }
//
//    @Scheduled(cron = "00/5 * * * * ?")
//    public void sendBarMessage(){
//        String message="HelloWorld,Bar";
//        ListenableFuture future = kafkaTemplate.send("bars",  new Bar(message));
//        future.addCallback(o -> log.info("send-消息发送成功：" + message), throwable -> log.error(("消息发送失败：" + message)));
//    }
}
