package com.akshay.springframework;

import com.akshay.springframework.game.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GamingConfigurations {

    @Bean
    public GameRunner gameRunner(Game game) {
        return new GameRunner(game);
    }

    @Primary
    @Bean
    public Game marioGame() {
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
