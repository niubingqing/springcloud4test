package com.bqniu.rabbitmq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rabbit.mq.queue.name")
@PropertySource("classpath:mq-queue-info.properties")
@Data
public class MqQueueInfoConfig {
    private String deletequeue = "delete";
    private String updatequeue = "update";
    private String insertqueue = "insert";
    private String testqueue1 = "msg001";
    private String testqueue2 = "msg002";
    private String testqueue3 = "msg003";

//    @Bean
//    @Scope("prototype")
//    public String getConfig() {
//        return "";
//    }
}
