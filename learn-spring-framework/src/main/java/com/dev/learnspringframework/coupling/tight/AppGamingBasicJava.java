package com.dev.learnspringframework.coupling.tight;

import com.dev.learnspringframework.coupling.tight.game.GameRunner;
import com.dev.learnspringframework.coupling.tight.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        //var superContraGame=new SuperContraGame();
        // for changing game wee have to do lot of thing in that:- Tight Coupling
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
