package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User register(User user) {
        return repository.save(user);
    }

    @Override
    public User login(String email, String password) {
        return repository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
