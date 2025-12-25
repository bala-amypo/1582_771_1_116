package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.User;

public interface UserService {
    UserDto registerUser(UserRegistrationDto registrationDto);
    User findByEmail(String email);
}