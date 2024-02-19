package com.learnSpring.restfulwebservices.helloworld;

import lombok.Data;

@Data
public class HelloWorldBean {

    String name;
    public HelloWorldBean(String name) {
        this.name=name;
    }
}
