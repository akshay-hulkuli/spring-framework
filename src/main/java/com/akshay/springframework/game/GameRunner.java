package com.akshay.springframework.game;

public class GameRunner {
    Game game;

    public GameRunner(Game game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running the game " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
