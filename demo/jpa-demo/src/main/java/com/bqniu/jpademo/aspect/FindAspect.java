package com.bqniu.jpademo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

public class FindAspect {
    @Pointcut("execution(* com.bqniu.jpademo.dao..*find(..))")
    public void findOperation(){}

    @Before("findOperation()")
    public void doBefore(JoinPoint joinPoint){
        //1.分解Args
        Object[] objects=joinPoint.getArgs();
        //2.计算Hash
        Arrays.stream(objects).forEach(x->{
            //String key = String.format("{%s}:{%s}:{%s}:{%s}","Test","user","name",HashCalculator.rsHash(x.toString()));
            int value = 0;


        });
        //3.验证是否在Redis，若Hash找不到SetNx(Key,0)，Hash找到值为1，查找value，若Hash找到值为0，不做处理
        //4.数据库LoadData Success->Set(key,1) Failed->不做处理
    }
}
