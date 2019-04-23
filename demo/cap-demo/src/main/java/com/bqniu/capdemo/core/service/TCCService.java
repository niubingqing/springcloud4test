package com.bqniu.capdemo.core.service;

import com.bqniu.capdemo.core.entity.TransShadow;
import com.bqniu.capdemo.core.repository.TCCRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TCCService {
    @Autowired
    TCCRepository tccRepository;

    public void addShadow(TransShadow shadow ){
        tccRepository.save(shadow);
    }
}
