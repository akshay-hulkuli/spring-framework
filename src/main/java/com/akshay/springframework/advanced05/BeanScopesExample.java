package com.akshay.springframework.advanced05;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
    Spring Singleton -> one instance per one IOC container.
    Java Singleton -> One instance per one java container.
    Singleton scope -> only one object will be created per IOC container. These are stateless(hold no specific data).
    Prototype scope -> n number of objects are created as and when it is referred to. these are stateful(holds data).
    in case of web application there can be these 4 additional scopes ->
        1. Request - per one http request.
        2. Session - per one user session.
        3. Application - per one web application.
        4. websocket - per one web socket.
 */

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopesExample {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(BeanScopesExample.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            // prints classes with same hashcode
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            // prints classes with different hashcode
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }
    }
}
