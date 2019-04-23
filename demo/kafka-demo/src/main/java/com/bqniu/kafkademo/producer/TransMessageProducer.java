package com.bqniu.kafkademo.producer;

import com.bqniu.kafkademo.common.Foo;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.transaction.KafkaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import static java.util.Arrays.stream;

@Slf4j
@Component
@EnableTransactionManagement
public class TransMessageProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(ArrayList message) {
        kafkaTemplate.executeInTransaction(kafkaTemplate -> {
            message.stream()
                    .map(s -> new Foo(s.toString()))
                    .forEach(foo -> {
                        kafkaTemplate.send("topic2", foo);
                        log.info("开始生产" + foo.toString());
                    });
            log.info("结束事务");
            return null;
        });
    }

    @Transactional
    public void sendMessage2(ArrayList message){
            message.stream().map(
                    s -> new Foo(s.toString())
            ).forEach(foo -> {
                kafkaTemplate.send("topic2", foo);
                log.info("开始生产" + foo.toString());
                if ("def".equals(((Foo) foo).getFoo())) {
                    throw new TransactionSystemException("异常");
                }
            });
    }


}
