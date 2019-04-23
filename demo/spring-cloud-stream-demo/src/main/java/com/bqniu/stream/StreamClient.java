package com.bqniu.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    @Input(value = "middle-ware-callback")
    SubscribableChannel input();  //用于接受消息

    @Output(value = "middle-ware-out")
    MessageChannel output();
}
