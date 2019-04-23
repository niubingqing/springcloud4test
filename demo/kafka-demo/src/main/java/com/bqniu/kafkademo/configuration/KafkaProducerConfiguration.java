package com.bqniu.kafkademo.configuration;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaProducerConfiguration {
//    @Autowired
//    private KafkaProperties properties;

//    @Bean
//    public KafkaProducer<String, String> configKafkaProducer() {
//        // create instance for properties to access producer configs
//        Properties props = new Properties();
//        // bootstrap.servers是Kafka集群的IP地址。多个时,使用逗号隔开
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("enable.idempotence", true);
//        //If the request fails, the producer can automatically retry,
//        props.put("retries", 3);
//        //Reduce the no of requests less than 0
//        props.put("linger.ms", 1);
//        //The buffer.memory controls the total amount of memory available to the producer for buffering.
//        props.put("buffer.memory", 33554432);
//        // Kafka消息是以键值对的形式发送,需要设置key和value类型序列化器
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
//        return producer;
//        //return new KafkaProducer(properties.getProducer().getProperties());
//    }
}
