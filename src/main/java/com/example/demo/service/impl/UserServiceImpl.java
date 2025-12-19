package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserAccountRepository userRepository;

    public UserServiceImpl(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
