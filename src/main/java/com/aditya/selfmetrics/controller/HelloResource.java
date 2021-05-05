package com.aditya.selfmetrics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("{id}")
    public String helloPerson(@PathVariable  String id){
        return "Hello " + id + "!";
    }
}
