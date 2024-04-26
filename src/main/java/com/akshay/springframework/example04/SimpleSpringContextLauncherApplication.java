package com.akshay.springframework.example04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {
            Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("Max value computed at BusinessCalculationService is  : " +
                    context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
