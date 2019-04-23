package com.bqniu.proxy;

import com.bqniu.proxy.dynamicsref.AdultMovie;
import com.bqniu.proxy.dynamicsref.Movie;
import com.bqniu.proxy.dynamicsref.Pornhub;
import com.bqniu.proxy.staticref.Animal;
import com.bqniu.proxy.staticref.Dog;
import com.bqniu.proxy.staticref.Mammal;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyApplication {
    public static void main(String[] args) {
        //静态代理
        Dog dog = new Dog();
        Animal animal = new Mammal(dog);
        animal.cry();
        //动态代理
        AdultMovie adultMovie=new AdultMovie();
        InvocationHandler handler=new Pornhub(adultMovie);
        Movie dynamicProxy = (Movie) Proxy.newProxyInstance(AdultMovie.class.getClassLoader(),
                AdultMovie.class.getInterfaces(), handler);

        dynamicProxy.play();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyApplication.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("before method run...");
            //Object result = proxy.invokeSuper(obj, args);
            test2();
            System.out.println("after method run...");
            return null;
        });
        ProxyApplication sample = (ProxyApplication) enhancer.create();
        sample.test();
    }

    public void test() {
        System.out.println("hello world");
    }

    public static void test2() {
        System.out.println("hello world 2");
    }
}
