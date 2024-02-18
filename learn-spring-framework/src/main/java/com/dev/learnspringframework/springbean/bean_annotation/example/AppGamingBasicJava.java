package com.dev.learnspringframework.springbean.bean_annotation.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        // launch spring context
        var context= new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // configure the things that we want spring to manage - @Configuartion
        //HelloWorldConfiguration--
        //name - @Bean


        System.out.println(context.getBean("age"));
        System.out.println(context.getBean(Person.class));
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }
}
