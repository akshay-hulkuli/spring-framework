package com.akshay.springframework.advanced05;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/*
    CDI - Context and dependency injection specifications by Jakarta EE.
    @Named =~ @Component(Spring annotation)
    @Inject =~ @Autowired(Spring annotation)
    Spring framework provides implementation for above specifications

    Other famous specification by Jakarta EE are
    1. CDI - Context and dependency injection
    2. JPA - Jakarta Persistence
    3. JSP - Jakarta Server pages
    etc
 */

//@Component
@Named
class BusinessService {

    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("setter injection");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService {

}


@Configuration
@ComponentScan
public class CDIContextLauncherApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class)) {
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
