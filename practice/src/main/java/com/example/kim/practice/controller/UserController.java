package com.example.kim.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/home")
    public String homePage() {
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
