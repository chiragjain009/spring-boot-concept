package com.dev.learnspringframework.springbean.bean_annotation.game;


import com.dev.learnspringframework.coupling.loose.game.GameConsole;
import com.dev.learnspringframework.coupling.loose.game.GameRunner;
import com.dev.learnspringframework.coupling.loose.game.MarioGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GameConfiguration {

    @Bean
    public GameConsole game(){
        return new MarioGame();
    }
    @Bean
    public GameRunner gameRunner(GameConsole game){
        return new GameRunner(game);
    }
}
