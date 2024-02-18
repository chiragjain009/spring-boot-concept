package com.springboot.learnjpaandhibernate.springjpa;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseSpringJpaRepository extends JpaRepository<Course,Long> {
    List<Course> findByAuthor(String author);
}
