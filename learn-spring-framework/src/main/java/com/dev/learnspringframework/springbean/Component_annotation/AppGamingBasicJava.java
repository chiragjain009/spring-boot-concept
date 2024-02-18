package com.dev.learnspringframework.springbean.Component_annotation;


import com.dev.learnspringframework.springbean.Component_annotation.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@ComponentScan
@Configuration
public class AppGamingBasicJava {
    public static void main(String[] args) {
        var context= new AnnotationConfigApplicationContext(AppGamingBasicJava.class);
        context.getBean(GameRunner.class).run();
//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);
    }
}
