package com.bqniu.stream;

import com.bqniu.common.MockDataBuilder;
import com.bqniu.common.dataobject.MessageInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
public class StreamRecevier {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @StreamListener("middle-ware-callback")  //监听middle-ware-callback这个消息队列, StreamClient类中必须定义相应的Input。
    public void receiver(Object message) {
        //1.模拟获取流程属性相关数据
        MessageInfo messageinfo = MockDataBuilder.getMessageInfoByWFid();
        //2.模拟封装数据
        messageinfo.setPayload(message);
        //3.转发路由
        amqpTemplate.convertAndSend(messageinfo.getNextStepExchange(), messageinfo.getNextStepRoutingkey(), message);
        System.out.println("接收到消息：" + message);
    }
}
