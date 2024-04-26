package com.akshay.springframework.game03;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MarioGame implements Game {
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Go in a hole");
    }

    public void left() {
        System.out.println("Left");
    }

    public void right() {
        System.out.println("Right");
    }
}
