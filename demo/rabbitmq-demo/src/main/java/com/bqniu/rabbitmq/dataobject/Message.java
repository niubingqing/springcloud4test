package com.bqniu.rabbitmq.dataobject;

import lombok.Data;

@Data
public class Message implements java.io.Serializable {
    private int id;
    private String content;
}
