//package com.bqniu.capdemo.core;
//
//import com.bqniu.capdemo.core.annotation.NotifyFrom;
//import com.bqniu.capdemo.core.annotation.NotifyTo;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.lang.reflect.Method;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class CapAnnotationProcessor implements ICapAnnotationProcessor {
//    @Autowired
//    private CachingConnectionFactory connectionFactory;
//
//    private ConcurrentHashMap<String,CapTransactionContext> concurrentHashMap;
//
//    @Override
//    public void process(Class<?> clazz) {
//        Method[] methods=clazz.getDeclaredMethods();
//        for(Method method :methods){
//            if(method.isAnnotationPresent(NotifyFrom.class)){
//                NotifyFrom input = (NotifyFrom) method.getAnnotation(NotifyFrom.class);
//            }
//
//            if(method.isAnnotationPresent(NotifyTo.class)){
//                NotifyTo output = (NotifyTo) method.getAnnotation(NotifyTo.class);
//            }
//        }
//
//        concurrentHashMap=new ConcurrentHashMap<String,CapTransactionContext>();
//
//    }
//}
