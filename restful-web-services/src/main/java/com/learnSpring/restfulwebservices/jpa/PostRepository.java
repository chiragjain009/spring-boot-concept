package com.learnSpring.restfulwebservices.jpa;

import com.learnSpring.restfulwebservices.post.Post;
import com.learnSpring.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
    
}
