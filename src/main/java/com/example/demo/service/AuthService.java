// package com.example.demo.service;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.JwtResponse;
// import com.example.demo.entity.User;

// public interface AuthService {

//     JwtResponse register(User user);

//     JwtResponse login(AuthRequest request);
// }
package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.JwtResponse;

public interface AuthService {

    JwtResponse register(AuthRequest request);

    JwtResponse login(AuthRequest request);
}
