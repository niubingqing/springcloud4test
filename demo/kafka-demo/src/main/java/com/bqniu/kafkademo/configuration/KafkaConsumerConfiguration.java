package com.bqniu.kafkademo.configuration;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConsumerConfiguration {
//    @Autowired
//    private KafkaProperties properties;
//
//    @Bean
//    public KafkaConsumer configKafkaConsumer(){
//        return  new KafkaConsumer(properties.getConsumer().getProperties());
//    }
}
