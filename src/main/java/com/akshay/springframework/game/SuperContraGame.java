package com.akshay.springframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("superContraGame")
public class SuperContraGame implements Game {
    public void up() {
        System.out.println("Up");
    }

    public void down() {
        System.out.println("Sit down");
    }

    public void left() {
        System.out.println("Left");
    }

    public void right() {
        System.out.println("Shoot a bullet");
    }
}
