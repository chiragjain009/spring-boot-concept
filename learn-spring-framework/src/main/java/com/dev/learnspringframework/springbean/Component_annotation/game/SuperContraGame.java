package com.dev.learnspringframework.springbean.Component_annotation.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGame")
public class SuperContraGame implements GameConsole {
    public void left(){
        System.out.println("left lelo");
    }

    public void right(){
        System.out.println("right lelo");
    }
}
