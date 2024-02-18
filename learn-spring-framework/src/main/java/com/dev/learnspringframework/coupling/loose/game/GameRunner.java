package com.dev.learnspringframework.coupling.loose.game;

public class GameRunner {
    GameConsole game;
    public GameRunner(GameConsole game) {
        this.game=game;
    }

    public void run() {
        System.out.println("game is started: "+ game);
        game.left();
        game.right();
    }
}
