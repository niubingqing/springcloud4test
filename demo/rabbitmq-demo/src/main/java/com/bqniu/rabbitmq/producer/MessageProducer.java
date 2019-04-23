package com.bqniu.rabbitmq.producer;

import com.bqniu.rabbitmq.config.MqQueueInfoConfig;
import com.bqniu.rabbitmq.config.RabbitMqConfig;
import com.bqniu.rabbitmq.dataobject.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private MqQueueInfoConfig mqQueueInfoConfig;

    public void sendMessage(String message){
        // amqpTemplate.convertAndSend(mqQueueInfoConfig.getTestqueue1(), message);
        amqpTemplate.convertAndSend(RabbitMqConfig.QUEUE_A, message);
    }

    public void sendMessage(Message message){
        amqpTemplate.convertAndSend(mqQueueInfoConfig.getTestqueue2(),message);
    }

    public void sendMessage2Exchange(String message) {
        amqpTemplate.convertAndSend("amq.fanout",mqQueueInfoConfig.getInsertqueue(),message);
    }

    public void sendMessageWithCallback(Message message){
        amqpTemplate.convertAndSend(RabbitMqConfig.QUEUE_A,message, new MessagePostProcessor() {
        // amqpTemplate.convertAndSend(mqQueueInfoConfig.getDeletequeue(),message, new MessagePostProcessor() {
            @Override
            public org.springframework.amqp.core.Message postProcessMessage(org.springframework.amqp.core.Message message) throws AmqpException {
                log.info(message.toString());
                return message;
            }
        });
    }
}
