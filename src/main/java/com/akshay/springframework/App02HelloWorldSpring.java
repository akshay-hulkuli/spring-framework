package com.akshay.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        // Launch a Spring context - Spring context/container manages bean creation, dependency injection, Inversion of control etc.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfigurationClass.class);

        // Configure the things that we want Spring to manage -> @Configuration class

        // Retrieving the Beans managed by Spring
        System.out.println(context.getBean("label"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters   "));
        System.out.println(context.getBean("addressOfJack"));
        // This another way of the bean retrieval using the type of the bean
        // But this works only when we have single bean of this type. otherwise we get No qualifying bean exception
        System.out.println(context.getBean(Address.class));
    }
}
