package com.aditya.selfmetrics.controller;

import com.aditya.selfmetrics.model.User;
import com.aditya.selfmetrics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{userName}")
    public User getUserById(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello There!";
    }
}
