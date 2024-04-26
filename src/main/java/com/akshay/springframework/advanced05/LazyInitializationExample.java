package com.akshay.springframework.advanced05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Lazy
class ClassA {
    private ClassA(){
        System.out.println("ClassA Constructor");
    }

}

@Component
// Lazy initialization of the bean, it will be created only when someone uses it. Eager is the default value.
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("ClassB constructor called");
        this.classA = classA;
    }
}

@Configuration
@ComponentScan
public class LazyInitializationExample {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(LazyInitializationExample.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("All the beans are loaded");
            System.out.println(context.getBean("classB"));
        }
    }
}
