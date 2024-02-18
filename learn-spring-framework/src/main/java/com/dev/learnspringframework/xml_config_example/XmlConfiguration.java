package com.dev.learnspringframework.xml_config_example;

import com.dev.learnspringframework.jakarta_annotation.JakartaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class DataWarehouse{
    Db1 db;

    public Db1 getDb() {
        return db;
    }
    @Autowired
    public void setDb(Db1 db) {
        this.db = db;
    }
}
@Component
class Db1{

}


public class XmlConfiguration {
    public static void main(String[] args) {

        try(var context=new ClassPathXmlApplicationContext("contextConfiguration.xml")){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//        System.out.println(context.getBean(XmlConfiguration.class).getDb());
        }
    }


}
