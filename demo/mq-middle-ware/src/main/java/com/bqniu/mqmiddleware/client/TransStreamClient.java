package com.bqniu.mqmiddleware.client;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface TransStreamClient {
    @Input("middleware-trans")
    SubscribableChannel input();
}
