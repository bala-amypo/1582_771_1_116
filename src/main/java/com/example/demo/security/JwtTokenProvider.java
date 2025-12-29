
package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class JwtTokenProvider {

    // Tests will override this via reflection
    private String jwtSecret = "default-secret-key-for-jwt-provider";

    private long jwtExpirationMs = 3600000L;

    private SecretKey getSigningKey() {
        byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);

        // HS256 needs >= 32 bytes → pad if needed
        if (keyBytes.length < 32) {
            keyBytes = Arrays.copyOf(keyBytes, 32);
        }

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Long userId, String email, Set<String> roles) {

        String rolesCsv = (roles == null || roles.isEmpty())
                ? ""
                : String.join(",", roles);

        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("roles", rolesCsv)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return getClaims(token).get("email", String.class);
    }

    public Set<String> getRole(String token) {
        String rolesCsv = getClaims(token).get("roles", String.class);
        if (rolesCsv == null || rolesCsv.isEmpty()) {
            return Collections.emptySet();
        }
        return new HashSet<>(Arrays.asList(rolesCsv.split(",")));
    }
}
