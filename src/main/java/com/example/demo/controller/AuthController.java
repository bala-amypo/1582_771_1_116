package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // POST /auth/register
    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        userService.registerUser(request.getEmail(), request.getPassword());
        return "User registered";
    }

    // POST /auth/login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = userService.login(request.getEmail(), request.getPassword());
        return new AuthResponse(token);
    }
}
