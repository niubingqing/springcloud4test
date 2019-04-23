package com.bqniu.aopdemo.controller;

import com.bqniu.aopdemo.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

@RestController
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @GetMapping("/msg")
    public String getMessage() throws Exception {
        try{
            String msg = messageService.getMessage();
            return  msg;
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/hello")
    public String hello() throws Exception {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new Exception("What?");
        }
        return "Hello world";
    }
}
