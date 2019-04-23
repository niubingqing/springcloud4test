package com.bqniu.aopdemo.service.Impl;

import com.bqniu.aopdemo.service.IMessageService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public String getMessage() throws Exception {
        Random random=new Random();
        if(random.nextBoolean()){
            throw new Exception("What?");
        }
        return "HelloWorld";
    }

    private int getSum(){
        return 0;
    }

    @Override
    public void sendMessage() {

    }
}
