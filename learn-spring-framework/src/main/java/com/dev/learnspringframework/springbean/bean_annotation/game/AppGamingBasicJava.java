package com.dev.learnspringframework.springbean.bean_annotation.game;

import com.dev.learnspringframework.coupling.loose.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        // launch spring context
        var context= new AnnotationConfigApplicationContext(GameConfiguration.class);
        context.getBean(GameRunner.class).run();

//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);

    }
}
