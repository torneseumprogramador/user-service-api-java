package com.java.microservicos.UserServiceAPI.controllers;

import com.java.microservicos.UserServiceAPI.models.User;
import com.java.microservicos.UserServiceAPI.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.save(user);
    }
}