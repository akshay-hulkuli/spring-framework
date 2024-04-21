package com.akshay.springframework;

import com.akshay.springframework.game.Game;
import com.akshay.springframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfigurations.class)) {
            context.getBean(Game.class).up();
            GameRunner gameRunner = context.getBean(GameRunner.class);
            gameRunner.run();
        }
    }
}
