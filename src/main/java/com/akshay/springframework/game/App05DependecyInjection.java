package com.akshay.springframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/*
    Some important definitions
    1. @Component : An instance of class will be managed by Spring framework.
    2. Dependency : The classes required for a class to run. Example : MarioGame is a dependency for GameRunner.
    3. @ComponentScan : Defines Spring framework to where to look for components. So that dependency injections can be
        performed.
    4. Dependency Injection : Identify all the beans, their dependencies and wire them together.
    5. Inversion of Control : Earlier developer used to create all the objects and used to wire them. But now the Spring
        framework is doing this task. Hence, the term Inversion of control.
    6. Spring Bean : An object managed by Spring framework.
    7. IOC container/ Spring container: Manages the lifecycle of beans and dependencies.
    8. Types of IOC container : ApplicationContext and BeanFactory(simple and rarely used).
    9. Autowiring : Process of wiring in dependencies for a Spring Bean.
 */

@Component
class BusinessClass {

    Dependency1 dependecy1;
    Dependency2 dependecy2;

    /* Constructor Injection */

    // putting @Autowired annotation is not mandatory for the constructor injection
    @Autowired
    public BusinessClass(Dependency1 dependecy1, Dependency2 dependecy2) {
        this.dependecy1 = dependecy1;
        this.dependecy2 = dependecy2;
    }

    /* - Setter Injection
        @Autowired
        public void setDependecy1(Dependency1 dependecy1) {
            this.dependecy1 = dependecy1;
        }

        @Autowired
        public void setDependecy2(Dependency2 dependecy2) {
            this.dependecy2 = dependecy2;
        }

     */


    /* - Field dependency injection -
        @Autowired
        Dependecy1 dependecy1;
        @Autowired
        Dependecy2 dependecy2;
     */

    @Override
    public String toString() {
        return "using " + dependecy1.toString() + " " + dependecy2.toString();
    }

}

@Component
class Dependency1 {
    @Override
    public String toString() {
        return "Dependency 1";
    }
}

@Component
class Dependency2 {
    @Override
    public String toString() {
        return "Dependency 2";
    }
}


@Configuration
// by default scans current package
@ComponentScan
public class App05DependecyInjection {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App05DependecyInjection.class)) {
            GameRunner gameRunner = context.getBean(GameRunner.class);
            for (String bean : context.getBeanDefinitionNames()) {
                System.out.println(bean);
            }
            System.out.println(context.getBean(BusinessClass.class));
            gameRunner.run();
        }
    }
}
