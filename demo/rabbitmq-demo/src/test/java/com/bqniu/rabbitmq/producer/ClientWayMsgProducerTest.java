package com.bqniu.rabbitmq.producer;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ClientWayMsgProducerTest {

    @Autowired
    ClientWayMsgProducer producer;

    @Test
    public void sendMsg() {
        producer.sendMsg("");
    }
}