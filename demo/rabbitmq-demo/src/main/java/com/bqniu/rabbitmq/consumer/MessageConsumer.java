package com.bqniu.rabbitmq.consumer;

import com.bqniu.rabbitmq.dataobject.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConsumer {

    //1.这种定义方式如果rabbitmq没有队列则会报错
    @RabbitListener(queues = "msg001")
    public void process1(String message){
        log.info("MqReceiver1: {}", message);
    }

    //2. 自动创建队列
    @RabbitListener(queuesToDeclare = @Queue("msg002"))
    public void process2(Message message){
        log.info("MqReceiver2: {}", message);
    }

    //3. 自动创建队列，Exchange 与 Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("msg003"),
            exchange = @Exchange("exmsg01")
    ))
    public void process3(String message){
        log.info("MqReceiver3: {}", message);
    }

    @RabbitListener(queues = "insert")
    public void insertProcess(Message message){
        log.info("insertMqReceiver1: {}", message);
    }

    @RabbitListener(queues = "delete")
    public void deleteProcess(Message message){
        log.info("deleteMqReceiver1: {}", message);
    }

    @RabbitListener(queues = "update")
    public void updateProcess(Message message){
        log.info("updateMqReceiver1: {}", message);
    }
}
