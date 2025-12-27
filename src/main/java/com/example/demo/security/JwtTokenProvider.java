package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    // 🔥 REQUIRED FIELD NAME (TEST USES REFLECTION)
    private String jwtSecret = "mySecretKey123456";

    private long jwtExpirationMs = 1000 * 60 * 60; // 1 hour

    public String generateToken(Long userId, String email, Set<String> roles) {

        String rolesCsv = String.join(",", roles);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("email", email)
                .claim("roles", rolesCsv)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    // 🔥 MUST BE PUBLIC (TEST CALLS THIS)
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public Long getUserIdFromToken(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    public Set<String> getRolesFromToken(String token) {
        String roles = getClaims(token).get("roles", String.class);
        return Arrays.stream(roles.split(","))
                .collect(Collectors.toSet());
    }
}
