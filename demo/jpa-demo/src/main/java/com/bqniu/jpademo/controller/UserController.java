package com.bqniu.jpademo.controller;

import com.bqniu.jpademo.dataobject.User;
import com.bqniu.jpademo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private UserService userService;

    @GetMapping("/user/{name}")
    public String findUsersByName(String name) throws JsonProcessingException, InterruptedException {
        return objectMapper.writeValueAsString(userService.findByName(name));
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }
}
