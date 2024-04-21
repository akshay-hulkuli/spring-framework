package com.akshay.springframework;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;


record Person(String name, int age) {
};

record Address(String street, String city, String state, String country) {
};

@Configurable
public class HelloWorldConfigurationClass {

    @Bean
    public String label() {
        return "Hello World";
    }

    @Bean
    public int age() {
        return 10;
    }

    @Bean
    public Person person() {
        return new Person("Jack", 18);
    }

    @Bean(name = "addressOfJack")
    public Address address() {
        return new Address("San Francisco", "CA", "CA", "USA");
    }
}
