package com.bqniu.mqmiddleware.service.impl;

import com.bqniu.mqmiddleware.repository.TransMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransMessageServiceImpl {
    @Autowired
    private TransMessageRepository transMessageRepository;

}
