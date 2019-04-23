package com.bqniu.capdemo.core.aspect;

import com.bqniu.capdemo.core.entity.TransShadow;
import com.bqniu.capdemo.core.repository.TCCRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CapTCCAddAspect {
    @Autowired
    TCCRepository tccRepository;

    private Logger logger = LoggerFactory.getLogger(CapTCCAddAspect.class);

    @Pointcut("@annotation(com.bqniu.capdemo.core.annotation.TCCAdd)")
    public void tccCancelAdd() { }

    @After("tccCancelAdd()")
    public void doAfter(JoinPoint point) throws Throwable{
        TransShadow shadow=new TransShadow();
        shadow.setBusinessId("");
        shadow.setPayLoad(Arrays.toString(point.getArgs()));
        shadow.setTransactionId(1);
        tccRepository.save(shadow);
    }

    @AfterReturning(returning = "ret", pointcut = "tccCancelAdd()")
    public void doAfterReturning(JoinPoint point, Object ret) throws Throwable {

    }
}
