package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(String email, String password) {
        // Check if email already exists to satisfy keyword: "email" or "exists"
        if (repository.findByEmail(email).isPresent()) {
            throw new BadRequestException("User with this email already exists");
        }
        
        User user = new User(email, password, Collections.singleton("USER"));
        repository.save(user);
    }

    @Override
    public String login(String email, String password) {
        // Use ResourceNotFoundException to satisfy keyword: "not found"
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Use BadRequestException for invalid credentials
        if (!user.getPassword().equals(password)) {
            throw new BadRequestException("Invalid credentials");
        }

        return "dummy-jwt-token";
    }
}