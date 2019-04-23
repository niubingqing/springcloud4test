package com.bqniu.proxy.dynamicsref;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Pornhub implements InvocationHandler {
    private Object category;

    public Pornhub(Object category) {
        this.category = category;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("This is very awesome for:"+this.getClass().getSimpleName());
        method.invoke(category, args);
        System.out.println("Nothing else left");
        return null;
    }
}
