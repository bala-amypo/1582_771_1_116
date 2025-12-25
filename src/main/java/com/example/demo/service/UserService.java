package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User registerUser(String email, String password);

    User findByEmail(String email);
}
