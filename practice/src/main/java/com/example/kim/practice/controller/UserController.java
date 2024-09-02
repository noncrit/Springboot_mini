package com.example.kim.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    public String homePage() {
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
