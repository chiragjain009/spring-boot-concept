package com.dev.learnspringframework.coupling.tight.game;

public class GameRunner {
    MarioGame game;
    public GameRunner(MarioGame marioGame) {
        this.game=marioGame;
    }

    public void run() {
        System.out.println("game is started: "+ game);
        game.left();
        game.right();
    }
}
