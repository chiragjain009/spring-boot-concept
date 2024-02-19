package com.springboot.myfirstwebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or database
    //in Memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        Function<String, String> passwordEncoder=input -> passwordEncoder().encode(input);
        UserDetails userDetails=createNewUser(passwordEncoder, "chirag", "1234");
        UserDetails userDetails1=createNewUser(passwordEncoder, "tanishq", "1234");
        return new InMemoryUserDetailsManager(userDetails1,userDetails);
    }

    private static UserDetails createNewUser(Function<String, String> passwordEncoder, String username, String password) {
        UserDetails userDetails=User.builder().passwordEncoder(passwordEncoder)
                    .username(username)
                    .password(password)
                    .roles("USER","ADMIN")
                    .build();
        return userDetails;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
    }




    //CSRF Frames
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
          auth -> auth.anyRequest().authenticated()
        );
        http.formLogin(withDefaults());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();

    }

}
