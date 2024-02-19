package com.springboot.myfirstwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayhello(){
        StringBuffer sb=new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My page</title>");
        sb.append("<head>");
        sb.append("<body>");
        sb.append("My first html page body");
        sb.append("<body>");
        sb.append("<html>");

        return sb.toString();
    }

    @RequestMapping("say-hello-JSP")
    public String sayhellojsp(){
        return "sayhello";
    }
}

//<dependency>
//<groupId>org.apache.tomcat.embed</groupId>
//<artifactId>tomcat-embed-jasper</artifactId>
//</dependency>