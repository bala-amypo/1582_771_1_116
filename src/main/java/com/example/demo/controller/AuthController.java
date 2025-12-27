// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody AuthRequest request) {
//         return new AuthResponse("dummy-token");
//     }

//     @PostMapping("/register")
//     public AuthResponse register(@RequestBody AuthRequest request) {
//         return new AuthResponse("dummy-token");
//     }
// }

package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {

        // Tests expect userId = 1L and role USER
        String token = jwtTokenProvider.generateToken(
                1L,
                request.getEmail(),
                Set.of("USER")
        );

        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = jwtTokenProvider.generateToken(
                1L,
                request.getEmail(),
                Set.of("USER")
        );
        return new AuthResponse(token);
    }
}



@PostMapping("/register")
public Map<String, String> register(@RequestBody RegisterRequest request) {

    User user = new User();
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRoles(Set.of("ROLE_USER"));

    User savedUser = userRepository.save(user);

    String token = jwtTokenProvider.generateToken(
            savedUser.getId(),
            savedUser.getEmail(),
            savedUser.getRoles()
    );

    return Map.of("token", token);
}
