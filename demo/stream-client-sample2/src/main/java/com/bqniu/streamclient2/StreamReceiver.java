package com.bqniu.streamclient2;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener("sample2-in")  //监听sample2-in这个消息队列, StreamClient类中必须定义相应的Input。
    public void receiver(Object message){
        System.out.println("接收到消息："+message);
    }
}
