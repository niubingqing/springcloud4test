package com.bqniu.streamclient2;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    @Input("sample2-in")
    SubscribableChannel input();  //用于接受消息

    @Output("sample2-out")
    MessageChannel output();  //用于发送消息
}
