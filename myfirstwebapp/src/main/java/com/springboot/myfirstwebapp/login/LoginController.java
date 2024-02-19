package com.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;

@Controller
@SessionAttributes("name")
public class LoginController {

        @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(ModelMap model) {
            model.put("name", getUsernameDetails());
            return "welcome";
        }


    public String getUsernameDetails(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


    //for this we will manage from Spring Security
//    @Autowired
//    private loginAuthenticationCheck loginAuthenticationCheck;
//    private Logger logger= LoggerFactory.getLogger(getClass());
//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String login(){
//        logger.debug("hi ji login page khol rha hu");
//        return "login";
//    }
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String loginWithPost(@RequestParam String name, @RequestParam String password,ModelMap model){
//        if(loginAuthenticationCheck.userIsValid(name,password)){
//            logger.debug("username and password entered");
//            model.put("name",name);
//            model.put("password",password);
//            return "welcome";
//        }else{
//            model.put("errorMessage","User details is invalid. Pls try again!");
//            return "login";
//        }
//    }
}
