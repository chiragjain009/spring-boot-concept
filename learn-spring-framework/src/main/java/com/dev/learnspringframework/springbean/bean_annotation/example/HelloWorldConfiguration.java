package com.dev.learnspringframework.springbean.bean_annotation.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name , int age ){};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "chirag jain";
    }

    @Bean
    public int age(){
        return 23;
    }

    @Bean
    @Primary
    public Person person1(){
        return new Person("tanishq", 24);
    }

    @Bean
    @Qualifier("bhai")
    public Person person2(){
        return new Person("nikhil", 24);
    }



}
