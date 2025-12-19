package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        // Normally you save to DB, but for Swagger correctness this is enough
        user.setId(1L);          // mock response
        user.setActive(true);    // default

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {

        // Normally validation happens here
        user.setId(1L);
        user.setActive(true);

        return ResponseEntity.ok(user);
    }
}
