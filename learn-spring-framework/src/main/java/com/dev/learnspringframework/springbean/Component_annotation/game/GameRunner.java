package com.dev.learnspringframework.springbean.Component_annotation.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    GameConsole game;
//    public GameRunner(@Qualifier("SuperContraGame") GameConsole game) {
//        this.game=game;
//    }
    public GameRunner(GameConsole game) {
        this.game=game;
    }

    public void run() {
        System.out.println("game is started: "+ game);
        game.left();
        game.right();
    }
}
