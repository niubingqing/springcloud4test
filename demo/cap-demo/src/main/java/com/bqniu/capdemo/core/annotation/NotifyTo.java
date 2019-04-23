package com.bqniu.capdemo.core.annotation;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE,
        ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NotifyTo {
    String value() default "";
    String exchange() default "";
    String routingKey() default "#";
}
