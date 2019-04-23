package com.bqniu.mqmiddleware.receiver;

import com.bqniu.mqmiddleware.client.TransStreamClient;
import com.bqniu.mqmiddleware.dataobject.TransMessageInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(TransStreamClient.class)
public class TransStreamReceiver {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @StreamListener("middleware-trans")
    public void receiver(TransMessageInfo message){
        //1.模拟获取流程属性相关数据
        //MessageInfo messageinfo = MockDataBuilder.getMessageInfoByWFid();
        //2.模拟封装数据
        //messageinfo.setPayload(message);
        //3.转发路由
        //amqpTemplate.convertAndSend(messageinfo.getNextStepExchange(), messageinfo.getNextStepRoutingkey(), message);
        //System.out.println("接收到消息：" + message);
    }
}
