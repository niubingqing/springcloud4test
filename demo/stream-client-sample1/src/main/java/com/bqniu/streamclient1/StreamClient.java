package com.bqniu.streamclient1;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    @Input("sample1-in")
    SubscribableChannel input();  //用于接受消息

    @Output("sample1-out")
    MessageChannel output();  //用于发送消息
}
