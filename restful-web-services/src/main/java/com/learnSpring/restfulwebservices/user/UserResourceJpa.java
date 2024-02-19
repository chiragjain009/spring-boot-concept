package com.learnSpring.restfulwebservices.user;

import com.learnSpring.restfulwebservices.jpa.PostRepository;
import com.learnSpring.restfulwebservices.jpa.UserRepository;
import com.learnSpring.restfulwebservices.post.Post;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResourceJpa {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public UserResourceJpa(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieeAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retreiveUserById(@PathVariable int id){
       Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())throw new UserNotFoundException("id:"+id);

        EntityModel<User> entityModel=EntityModel.of(user.get());
        WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieeAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser=userRepository.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUserById(@PathVariable int id){
        userRepository.deleteById(id);
    }

    //get posts based on user
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> reterivePostsByUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())throw new UserNotFoundException("id:"+id);
        return user.get().getPosts();

    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<User> createUser(@PathVariable int id,@Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
        post.setUser(user.get());
        Post savedPost=postRepository.save(post);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
