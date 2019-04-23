package com.bqniu.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface StreamClient {
    @Input("in")
    SubscribableChannel input();

    @Output("out")
    MessageChannel output();

}
