package com.akshay.springframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

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
        System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("addressOfJack"));
        // This another way of the bean retrieval using the type of the bean
        // But this works only when we have single bean of this type. otherwise we get No qualifying bean exception
        // This can be solved in 2 ways by making one of the bean as @Primary or using @Qualifier annotation(can't be used in this example)
        System.out.println(context.getBean(Address.class));
        // IOC container == Bean factory == Application context -> which manages the bean creation and its life cycles.
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
