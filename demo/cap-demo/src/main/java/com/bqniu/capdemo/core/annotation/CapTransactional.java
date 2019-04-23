package com.bqniu.capdemo.core.annotation;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Transactional
public @interface CapTransactional {
    String value() default "";
    String key() default "";
    String operation() default "";
    //boolean ifInternalErrorRollingBack() default false;
}
