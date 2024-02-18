package com.dev.learnspringframework.springbean.Component_annotation.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GameConsole {
    public void left(){
        System.out.println("left lelo");
    }

    public void right(){
        System.out.println("right lelo");
    }

}
