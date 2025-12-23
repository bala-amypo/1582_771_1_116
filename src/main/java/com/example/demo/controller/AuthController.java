package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String email,
            @RequestParam String password) {

        userService.registerUser(email, password);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(


        
            @RequestParam String email,
            @RequestParam String password) {

        String token = userService.login(email, password);
        if (token == null) {
            return "Invalid credentials";
        }
        return token;
    }
}
