package com.bqniu.kafkademo.producer;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

@Component
public class TransKafkaClientProducer {
    /**
     * 在一个事务只有生产消息操作
     */
    public void onlyProduceInTransaction() {
        KafkaProducer<String, String> kafkaProducer = configKafkaProducer();
        // 1.初始化事务
        kafkaProducer.initTransactions();
        // 2.开启事务
        kafkaProducer.beginTransaction();
        try {
            // 3.kafka写操作集合
            // 3.1 do业务逻辑
            // 3.2 发送消息
            kafkaProducer.send(new ProducerRecord<String, String>("test", "transaction-data-1"));
            kafkaProducer.send(new ProducerRecord<String, String>("test", "transaction-data-2"));
            // 3.3 do其他业务逻辑,还可以发送其他topic的消息。
            // 4.事务提交
            kafkaProducer.commitTransaction();
        } catch (Exception e) {
            // 5.放弃事务
            kafkaProducer.abortTransaction();
        }
    }

    /**
     * 在一个事务内,即有生产消息又有消费消息
     */
    public void consumeTransferProduce() {
        // 2.初始化事务(生成productId),对于一个生产者,只能执行一次初始化事务操作
        KafkaProducer<String, String>  kafkaProducer = configKafkaProducer();
        kafkaProducer.initTransactions();
        // 3.构建消费者和订阅主题
        KafkaConsumer<String, String> kafkaConsumer = configKafkaConsumer();
        kafkaConsumer.subscribe(Arrays.asList("test"));
        while (true) {
            // 4.开启事务
            kafkaProducer.beginTransaction();
            // 5.1 接受消息
            ConsumerRecords<String, String> records = kafkaConsumer.poll(500);
            try {
                // 5.2 do业务逻辑;
                System.out.println("customer Message---");
                Map<TopicPartition, OffsetAndMetadata> commits = Maps.newHashMap();
                for (ConsumerRecord<String, String> record : records) {
                    // 5.2.1 读取消息,并处理消息。print the offset,key and value for the consumer records.
                    System.out.printf("offset = %d, key = %s, value = %s\n",
                            record.offset(), record.key(), record.value());
                    // 5.2.2 记录提交的偏移量
                    commits.put(new TopicPartition(record.topic(), record.partition()),
                            new OffsetAndMetadata(record.offset()));
                    // 6.生产新的消息。
                    kafkaProducer.send(new ProducerRecord<String, String>("test", "data2"));
                }
                // 7.提交偏移量
                kafkaProducer.sendOffsetsToTransaction(commits, "group0323");
                // 8.事务提交
                kafkaProducer.commitTransaction();
            } catch (Exception e) {
                // 7.放弃事务
                kafkaProducer.abortTransaction();
            }
        }
    }

    /**
     * * 在一个事务只有消息操作
     */
    public void onlyConsumeInTransaction() {
        KafkaProducer<String, String>  producer = configKafkaProducer();
        // 1.初始化事务
        producer.initTransactions();
        // 2.开启事务
        producer.beginTransaction();
        // 3.kafka读消息的操作集合
        KafkaConsumer<String, String> consumer = configKafkaConsumer();
        while (true) {
            // 3.1 接受消息
            ConsumerRecords<String, String> records = consumer.poll(500);
            try {
                // 3.2 do业务逻辑;
                System.out.println("customer Message---");
                Map<TopicPartition, OffsetAndMetadata> commits = Maps.newHashMap();
                for (ConsumerRecord<String, String> record : records) {
                    // 3.2.1 处理消息 print the offset,key and value for the consumer records.
                    System.out.printf("offset = %d, key = %s, value = %s\n",
                            record.offset(), record.key(), record.value());
                    // 3.2.2 记录提交偏移量
                    commits.put(new TopicPartition(record.topic(), record.partition()),
                            new OffsetAndMetadata(record.offset()));

                }
                // 4.提交偏移量
                producer.sendOffsetsToTransaction(commits, "group0323");
                // 5.事务提交
                producer.commitTransaction();
            } catch (Exception e) {

                // 6.放弃事务
                producer.abortTransaction();
            }
        }
    }

    private KafkaProducer<String, String> configKafkaProducer() {
        // create instance for properties to access producer configs
        Properties props = new Properties();
        // bootstrap.servers是Kafka集群的IP地址。多个时,使用逗号隔开
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("enable.idempotence", true);
        //If the request fails, the producer can automatically retry,
        props.put("retries", 3);
        //Reduce the no of requests less than 0
        props.put("linger.ms", 1000);
        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);
        props.put("transactional.id", "tx");
        // Kafka消息是以键值对的形式发送,需要设置key和value类型序列化器
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        return producer;
        //return new KafkaProducer(properties.getProducer().getProperties());
    }

    private KafkaConsumer<String, String> configKafkaConsumer() {
        // create instance for properties to access producer configs
        Properties props = new Properties();
        // bootstrap.servers是Kafka集群的IP地址。多个时,使用逗号隔开
        props.put("bootstrap.servers", "127.0.0.1:9092");
        // 消费者群组
        props.put("group.id", "group0323");
        // 设置隔离级别
        props.put("isolation.level", "read_committed");
        // 关闭自动提交
        props.put("enable.auto.commit", "false");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer
                <String, String>(props);
        return consumer;
        //return new KafkaProducer(properties.getProducer().getProperties());
    }

    public ConsumerRecords<String, String> getConsumerRecords() {
        KafkaConsumer<String, String> kafkaConsumer = configKafkaConsumer();
        kafkaConsumer.subscribe(Arrays.asList("test"));
        ConsumerRecords<String, String> records = kafkaConsumer.poll(500);

        return records;
    }
}
