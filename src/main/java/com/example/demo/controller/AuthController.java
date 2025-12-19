package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    // POST /auth/register
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        response.put("email", request.get("email"));
        return response;
    }

    // POST /auth/login
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("email", request.get("email"));
        response.put("token", "dummy-token");
        return response;
    }
}
