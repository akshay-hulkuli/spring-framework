package com.akshay.springframework.game;

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
