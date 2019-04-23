package com.bqniu.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
@Component
@Aspect
public class ServiceAspect {
    //private Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

    /**
     * 定义切入点，切入点为com.bqniu.aopdemo.service下的所有函数
     */
    @Pointcut("execution(public * com.bqniu.aopdemo.service..*(..))")
    public void serviceLog() {
    }

    @Before("serviceLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        log.info("@Before:待执行目标方法： " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "ret", pointcut = "serviceLog()")
    public void doAfterReturning(JoinPoint point, Object ret) throws Throwable {
        // 处理完请求，返回内容
        StringBuilder builder = new StringBuilder();
        builder.append("@AfterReturning：目标方法为：");
        builder.append(point.getSignature().getDeclaringTypeName());
        builder.append(".");
        builder.append(point.getSignature().getName());
        builder.append("参数为：");
        builder.append(Arrays.toString(point.getArgs()));
        builder.append("被织入的目标对象为：");
        builder.append(point.getTarget());
        builder.append("执行返回后： ");
        builder.append(ret);
        log.info(builder.toString());
    }

    @After("serviceLog()")
    public void doAfter(JoinPoint point) throws Throwable {
        StringBuilder builder = new StringBuilder();
        builder.append("@After：目标方法为：");
        builder.append(point.getSignature().getDeclaringTypeName());
        builder.append(".");
        builder.append(point.getSignature().getName());
        builder.append("参数为：");
        builder.append(Arrays.toString(point.getArgs()));
        builder.append("被织入的目标对象为：");
        builder.append(point.getTarget());

        log.info(builder.toString());
    }

    @Around("serviceLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("@Around：执行目标方法之前...");
        Object obj = proceedingJoinPoint.proceed();
        log.info("@Around：执行目标方法之后..被织入的目标对象为：" + proceedingJoinPoint.getTarget() + "原返回值：" + obj );

        return obj;
    }
    /*
    * 如果目标方法中出现异常，并由catch捕捉处理且catch又没有抛出新的异常，那么针对该目标方法的AfterThrowing增强处理将不会被执行。
    */
    @AfterThrowing(throwing = "ex",pointcut = "serviceLog()")
    public void doAfterThrowing(Exception ex) {
        log.error("异常通知....异常信息："+ex.getMessage());
    }
}
