package com.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class loginAuthenticationCheck {
    public boolean userIsValid(String name,String password){
        return name.equals("chirag")&&password.equals("1234");
    }

}
