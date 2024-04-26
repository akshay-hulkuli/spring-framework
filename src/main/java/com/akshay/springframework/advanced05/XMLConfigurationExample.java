package com.akshay.springframework.advanced05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLConfigurationExample {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
