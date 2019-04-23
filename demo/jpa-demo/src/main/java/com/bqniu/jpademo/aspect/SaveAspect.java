package com.bqniu.jpademo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;

public class SaveAspect {

    @Pointcut("execution(* com.bqniu.jpademo.dao..*find(..))")
    public void saveOperation(){}

    @AfterReturning(returning = "ret", pointcut = "findOperation()")
    public void doAfterReturing(JoinPoint point, Object ret) {
        //1.计算Key Hash，反向更新Redis值
        //2.插入Key值并计算Hash，并置位置为1
    }
}
