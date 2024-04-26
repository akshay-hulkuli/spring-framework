package com.akshay.springframework;

import com.akshay.springframework.game03.GameRunner;
import com.akshay.springframework.game03.MarioGame;
import com.akshay.springframework.game03.PacManGame;
import com.akshay.springframework.game03.SuperContraGame;

public class App01GamingBasicsJava {
    public static void main(String[] args) {

        /*
            This is a tightly coupled code. As adding a new game is difficult. As you have tp create new constructor
            Coupling the measure of the amount of the work needed inder to make some changes.
            We want to make functional changes with as less code as possible.
         */
        MarioGame marioGame = new MarioGame();
        GameRunner gameRunner = new GameRunner(marioGame);
        gameRunner.run();

        /*
            To achieve loose coupling we need to introduce an interface.
         */
        MarioGame marioGame2 = new MarioGame();
        SuperContraGame superContraGame = new SuperContraGame(); // Object creation
        PacManGame pacManGame = new PacManGame();
        gameRunner = new GameRunner(marioGame2); // wiring the dependency.
        gameRunner.run();
        gameRunner = new GameRunner(superContraGame);
        gameRunner.run();
        gameRunner = new GameRunner(pacManGame);
        gameRunner.run();
    }
}
