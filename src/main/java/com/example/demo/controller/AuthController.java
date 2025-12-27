// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.JwtResponse;
// import com.example.demo.entity.User;
// import com.example.demo.service.AuthService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import io.swagger.v3.oas.annotations.security.SecurityRequirements;


// @RestController
// @RequestMapping("/auth")
// @SecurityRequirements // 🔓 This overrides the global setting and removes all locks for this controller
// public class AuthController {

//     private final AuthService authService;

//     public AuthController(AuthService authService) {
//         this.authService = authService;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<JwtResponse> register(@RequestBody User user) {
//         return ResponseEntity.ok(authService.register(user));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest request) {
//         return ResponseEntity.ok(authService.login(request));
//     }
// }


package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// 🛠️ ADD THIS MISSING IMPORT
import io.swagger.v3.oas.annotations.security.SecurityRequirements;

@RestController
@RequestMapping("/auth")
@SecurityRequirements // 🔓 Removes lock symbols from all methods in this controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}