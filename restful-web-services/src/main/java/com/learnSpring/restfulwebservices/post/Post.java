package com.learnSpring.restfulwebservices.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learnSpring.restfulwebservices.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue
    private Integer Id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

}
