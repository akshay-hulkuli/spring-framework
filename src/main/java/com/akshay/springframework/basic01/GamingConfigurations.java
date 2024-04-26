package com.akshay.springframework.basic01;

import com.akshay.springframework.game03.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GamingConfigurations {

    @Bean
    public GameRunner gameRunner(@Qualifier("superContraGame") Game game) {
        return new GameRunner(game);
    }

    @Primary
    @Bean
    public Game marioGameee() {
        return new MarioGame();
    }

    @Bean
    public Game superContraGame() {
        return new SuperContraGame();
    }

    @Bean
    public Game pacManGame() {
        return new PacManGame();
    }
}
