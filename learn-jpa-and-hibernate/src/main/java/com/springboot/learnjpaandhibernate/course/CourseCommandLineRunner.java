package com.springboot.learnjpaandhibernate.course;

import com.springboot.learnjpaandhibernate.jdbc.CourseJdbcRepository;
import com.springboot.learnjpaandhibernate.jpa.CourseJpaRepository;
import com.springboot.learnjpaandhibernate.springjpa.CourseSpringJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringJpaRepository repository;
//    private CourseJpaRepository repository;
//    private CourseJdbcRepository repository;


    //for JPA and spring jdbc,jdbc
//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course(1,"aws JPA","CHIRAG GFG"));
//        repository.insert(new Course(2,"aws JPA","GFG"));
//        repository.insert(new Course(3,"aws JPA","GFG"));
//        repository.deleteById(2);
//        System.out.println(repository.findById(1));
//    }

    //spring JPA
    @Override
    public void run(String... args) throws Exception {

        repository.save(new Course(1,"aws spring JPA","CHIRAG GFG"));
        repository.save(new Course(2,"aws spring JPA","GFG"));
        repository.save(new Course(3,"aws spring JPA","GFG"));
        repository.deleteById(2l);
        System.out.println(repository.findById(1l));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("CHIRAG GFG"));
    }
}
