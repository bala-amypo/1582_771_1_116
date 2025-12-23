package com.example.demo.service;

public interface UserService {
    void registerUser(String email, String password);
    String login(String email, String password);
}