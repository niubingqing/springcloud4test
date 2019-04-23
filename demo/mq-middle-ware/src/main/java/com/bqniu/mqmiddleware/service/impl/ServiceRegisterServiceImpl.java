package com.bqniu.mqmiddleware.service.impl;

import com.bqniu.mqmiddleware.repository.ServiceRegisterRepository;
import com.bqniu.mqmiddleware.service.ServiceRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegisterServiceImpl {
    @Autowired
    private ServiceRegisterRepository serviceRegisterRepository;


}
