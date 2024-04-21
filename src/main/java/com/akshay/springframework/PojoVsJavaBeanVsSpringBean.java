package com.akshay.springframework;

import java.io.Serializable;

public class PojoVsJavaBeanVsSpringBean {
    // Let us see the difference between Pojo vs JavaBean and Spring bean.
}

class Pojo {
    String name;
    int age;
}

// This must implement Serializable interface
class JavaBean implements Serializable {
    String name;
    int age;

    // There must be a no-args constructor
    public JavaBean() {
    }

    // There must be Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
