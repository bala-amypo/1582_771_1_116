// package com.example.demo.dto;

// import lombok.AllArgsConstructor;
// import lombok.Data;

// @Data
// @AllArgsConstructor
// public class AuthResponse {
//     private String token;
//     private Long userId;
//     private String email;
//     private String role;
// }
package com.example.demo.dto;

public class AuthResponse {

    private String token;

    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
