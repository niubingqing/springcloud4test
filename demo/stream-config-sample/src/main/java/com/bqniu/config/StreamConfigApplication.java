package com.bqniu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(StreamClient.class)
public class StreamConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamConfigApplication.class, args);
    }
}
