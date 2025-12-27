package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/users")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        return dto;
    }
}
