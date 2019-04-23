package com.bqniu.streamclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.util.MimeType;

@SpringBootApplication
public class StreamClientSample2Application {

    public static void main(String[] args) {
        SpringApplication.run(StreamClientSample2Application.class, args);

    }
}
