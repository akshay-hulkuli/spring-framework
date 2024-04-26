package com.akshay.springframework.advanced05;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    SomeDependency someDependency;
    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("SomeClass constructor");
    }

    // This will be called after the bean has been initialized(after all dependency injection is completed)
    @PostConstruct
    public void init() {
        someDependency.getReady();
    }

    @PreDestroy
    public void destroy() {
        someDependency.cleanup();
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("SomeDependency getReady");
    }

    public void cleanup() {
        System.out.println("SomeDependency cleanup");
    }
}


@Configuration
@ComponentScan
public class PreDestroyPostConstructAnnotationsExample {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(PreDestroyPostConstructAnnotationsExample.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
