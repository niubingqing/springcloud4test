//package com.bqniu.rabbitmqdemo;
//
//import com.rabbitmq.client.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextStartedEvent) {
//        ApplicationContext applicationContext = contextStartedEvent.getApplicationContext();
//        ApplicationContext parent = applicationContext.getParent();
//        if (parent == null) {
//            new Thread(
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            ConnectionFactory connectionFactory = new ConnectionFactory();
//                            connectionFactory.setUsername("bqniu");
//                            connectionFactory.setPassword("123456");
//                            connectionFactory.setHost("localhost");
//                            connectionFactory.setPort(5672);
//                            connectionFactory.setVirtualHost("/");
//                            connectionFactory.setConnectionTimeout(600000); // in milliseconds
//                            connectionFactory.setRequestedHeartbeat(60); // in seconds
//                            connectionFactory.setHandshakeTimeout(6000); // in milliseconds
//                            connectionFactory.setRequestedChannelMax(5);
//                            connectionFactory.setNetworkRecoveryInterval(500);
//                            try {
//                                Connection connection = connectionFactory.newConnection();
//                                Channel channel = connection.createChannel();
//
//                                channel.queueDeclare("msg001", false, false, false, null);
//                                System.out.println("Waiting for messages. ");
//
//                                Consumer consumer = new DefaultConsumer(channel) {
//                                    @Override
//                                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
//                                            throws IOException {
//                                        String message = new String(body, "UTF-8");
//                                        System.out.println(" [x] Received '" + message + "'");
//                                    }
//                                };
//                                channel.basicConsume("msg001", true, consumer);
//                            } catch (IOException e) {
//
//                            } catch (TimeoutException e) {
//
//                            }
//                        }
//                    }).start();
//        }
//    }
//}
