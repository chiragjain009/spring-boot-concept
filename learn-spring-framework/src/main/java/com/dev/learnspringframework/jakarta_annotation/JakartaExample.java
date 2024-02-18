package com.dev.learnspringframework.jakarta_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Component;
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
@Configuration
@ComponentScan
public class JakartaExample {
    public static void main(String[] args) {

        try(var context=new AnnotationConfigApplicationContext(JakartaExample.class)){
            System.out.println(context.getBean(DataWarehouse.class).getDb());
        }

    }
}
