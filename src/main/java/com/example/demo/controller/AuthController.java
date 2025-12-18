package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> body) {
        return userService.registerUser(
                body.get("email"),
                body.get("password")
        );
    }

    @PostMapping("/login")
    public String login() {
        return "Login successful";
    }
    
}
