package com.example.demo.service.impl;

import com.example.demo.entity.User;
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
        User user = new User(email, password, Collections.singleton("USER"));
        repository.save(user);
    }

    @Override
    public String login(String email, String password) {
        Optional<User> optional = repository.findByEmail(email);
        if (optional.isEmpty()) return null;

        if (!optional.get().getPassword().equals(password)) return null;

        return "dummy-jwt-token";
    }
}
