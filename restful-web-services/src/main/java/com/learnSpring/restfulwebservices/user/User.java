package com.learnSpring.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learnSpring.restfulwebservices.post.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="user_details")
public class User {

    //@JsonProperty("id_ji")
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=5)
    private String name;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;


}
