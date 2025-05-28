package com.java.microservicos.UserServiceAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "API UserService está rodando!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}