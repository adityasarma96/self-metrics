package com.aditya.selfmetrics.controller;

import com.aditya.selfmetrics.model.User;
import com.aditya.selfmetrics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id){
        return userRepository.getUserById(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userRepository.addUser(user);
    }

    /*@GetMapping("/users")
    public Collection<User> getAllUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }*/
}
