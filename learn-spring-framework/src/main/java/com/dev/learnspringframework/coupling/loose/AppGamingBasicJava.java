package com.dev.learnspringframework.coupling.loose;

import com.dev.learnspringframework.coupling.loose.game.GameConsole;
import com.dev.learnspringframework.coupling.loose.game.GameRunner;
import com.dev.learnspringframework.coupling.loose.game.MarioGame;
import com.dev.learnspringframework.coupling.loose.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        GameConsole game = new MarioGame();
        GameConsole game1 = new SuperContraGame();//1: object Creation

        var gameRunner = new GameRunner(game); //2: object creation + wiring of dependency

        //we have changed code to loose couple . we created interface of game .
        gameRunner.run();
    }
}
