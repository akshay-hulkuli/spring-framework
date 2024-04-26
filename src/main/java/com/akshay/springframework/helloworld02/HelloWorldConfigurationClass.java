package com.akshay.springframework.helloworld02;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;


record Person(String name, int age, Address address) {
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
    public String name() {
        return "Akshay";
    }

    @Bean
    public int age() {
        return 10;
    }

    @Bean
    public Person person() {
        return new Person("Jack", 18, new Address("London", "London", "London", "London"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), 24, new Address("London", "London", "London", "London"));
    }

    // here spring auto wires the required beans for this method, since it is a bean method.
    @Bean
    public Person person3Parameters(String name, int age, Address address2) {
        return new Person(name(), 24, new Address("London", "London", "London", "London"));
    }

    @Bean(name = "addressOfJack")
    @Primary
    public Address address2() {
        return new Address("San Francisco", "CA", "CA", "USA");
    }
}
