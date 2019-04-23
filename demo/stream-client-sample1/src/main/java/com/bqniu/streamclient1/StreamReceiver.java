package com.bqniu.streamclient1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener("sample1-in")  //监听sample1-in这个消息队列, StreamClient类中必须定义相应的Input。
    @SendTo("middle-ware-callback")  //该注解会在消息处理完成后，向sample1-callback这个队列发送消息。消息内容就是该方法的返回值。
    public Object receiver(Object message){
        System.out.println("接收到消息："+message);
        return message;
    }

    @Autowired
    private  StreamClient streamClient;

    public void sendMessage(){
        streamClient.output().send(MessageBuilder.withPayload("wake up!!!").build());
    }
}
