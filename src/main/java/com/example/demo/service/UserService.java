package com.example.portal.service;

import com.example.portal.entity.User;

public interface UserService {
    User registerUser(String email, String password);

    User getUserByEmail(String email);
}
