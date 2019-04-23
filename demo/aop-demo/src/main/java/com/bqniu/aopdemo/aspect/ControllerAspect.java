package com.bqniu.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class ControllerAspect {
    private Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    /**
     * 任意公共方法的执行：
     * execution(public * *(..))
     * public可以省略, 第一个* 代表方法的任意返回值 第二个参数代表任意包+类+方法 （..）任意参数
     *
     * 任何一个以“get”开始的方法的执行：
     * execution(* get*(..))
     *
     * HelloController内部任意方法：
     * execution(* com.example.demo.controller.HelloController.*(..))
     *
     * 定义在com.example.demo.controller包里的任意方法的执行：
     * execution(* com.example.demo.controller.*.*(..))
     * #第一个 .* 代表任意类, 第二个 .* 代表任意方法
     *
     * 定义在com.example.demo.controller包和所有子包里的任意类的任意方法的执行：
     * execution(* com.coffee.service..*.*(..))
     * # ..* 代表任意包或者子包
     *
     * 定义在com.example.demo包和所有子包里的HelloController类的任意方法的执行：
     * execution(* com.example.demo..HelloController.*(..))")
     *
     * 在多个表达式之间使用 ||,or表示 或，使用 &&,and表示 与，！表示 非.
     *
     * 定义切入点，切入点为com.bqniu.aopdemo.controller下的所有前缀为hello的函数
     */
    //@Pointcut("execution(public * com.example.demo.controller..*.hello*(..))||execution(public * com.example.demo.controller..*.get*(..))")
    //@Pointcut("execution(public * com.bqniu.aopdemo.controller..*.hello*(..))")
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void webLog(){}

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("@ Before: ");
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("webLog()")
    public void doAfter(JoinPoint point) throws Throwable{
        StringBuilder builder=new StringBuilder();
        builder.append("@After：目标方法为：");
        builder.append(point.getSignature().getDeclaringTypeName());
        builder.append(".");
        builder.append(point.getSignature().getName());
        builder.append("参数为：");
        builder.append(Arrays.toString(point.getArgs()));
        builder.append("被织入的目标对象为：");
        builder.append(point.getTarget());

        logger.info(builder.toString());
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("@AfterReturning：RESPONSE : " + ret);
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("@Around：执行目标方法之前...");
        Object obj= proceedingJoinPoint.proceed();
        logger.info("@Around：执行目标方法之后..被织入的目标对象为：" + proceedingJoinPoint.getTarget()+"原返回值：" + obj );
        return obj;
    }

    @AfterThrowing(throwing = "ex",pointcut = "webLog()")
    public void doAfterThrowing(Exception ex){
        logger.error("异常通知...."+ex.getMessage());
    }
}
