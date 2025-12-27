// // package com.example.demo.security;

// // import io.jsonwebtoken.*;
// // import io.jsonwebtoken.security.Keys;
// // import org.springframework.stereotype.Component;

// // import javax.crypto.SecretKey;
// // import java.nio.charset.StandardCharsets;
// // import java.util.Date;
// // import java.util.Set;

// // @Component
// // public class JwtTokenProvider {

// //     // injected via reflection in tests
// //     private String jwtSecret = "default-secret-key-default-secret-key-default-secret-key";
// //     private long jwtExpirationMs = 86400000;

// //     private SecretKey getSigningKey() {
// //         byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);

// //         // Ensure minimum 512-bit key for HS512 (64 bytes)
// //         if (keyBytes.length < 64) {
// //             byte[] padded = new byte[64];
// //             for (int i = 0; i < padded.length; i++) {
// //                 padded[i] = keyBytes[i % keyBytes.length];
// //             }
// //             keyBytes = padded;
// //         }

// //         return Keys.hmacShaKeyFor(keyBytes);
// //     }

// //     public String generateToken(Long userId, String email, Set<String> roles) {

// //         return Jwts.builder()
// //                 .setSubject(email)
// //                 .claim("userId", userId)
// //                 .claim("email", email)
// //                 .claim("roles", String.join(",", roles))
// //                 .setIssuedAt(new Date())
// //                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
// //                 .signWith(getSigningKey(), SignatureAlgorithm.HS512)
// //                 .compact();
// //     }

// //     public boolean validateToken(String token) {
// //         try {
// //             Jwts.parserBuilder()
// //                     .setSigningKey(getSigningKey())
// //                     .build()
// //                     .parseClaimsJws(token);
// //             return true;
// //         } catch (JwtException | IllegalArgumentException ex) {
// //             return false;
// //         }
// //     }

// //     public Claims getClaims(String token) {
// //         return Jwts.parserBuilder()
// //                 .setSigningKey(getSigningKey())
// //                 .build()
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //     }

// //     public String getUsername(String token) {
// //         return getClaims(token).getSubject();
// //     }
// // }
// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import java.security.Key;
// import java.util.*;
// import java.util.stream.Collectors;

// @Component
// public class JwtTokenProvider {

//     // ⚠️ NOT private (tests inject via reflection)
//     String jwtSecret;
//     long jwtExpirationMs;

//     private Key getSigningKey() {
//         return Keys.hmacShaKeyFor(jwtSecret.getBytes());
//     }

//     public String generateToken(Long userId, String email, Set<String> roles) {
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("userId", userId);
//         claims.put("email", email);
//         claims.put("roles", String.join(",", roles));

//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + jwtExpirationMs);

//         return Jwts.builder()
//             .setClaims(claims)
//             .setSubject(email)
//             .setIssuedAt(now)
//             .setExpiration(expiry)
//             .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//             .compact();
//     }

//     public Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//             .setSigningKey(getSigningKey())
//             .build()
//             .parseClaimsJws(token)
//             .getBody();
//     }

//     public String getUsername(String token) {
//         return getClaims(token).getSubject();
//     }

//     public Set<String> getRole(String token) {
//         String roles = (String) getClaims(token).get("roles");
//         return Arrays.stream(roles.split(",")).collect(Collectors.toSet());
//     }

//     public boolean validateToken(String token) {
//         try {
//             getClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // Inject properties from application.properties
    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expirationMs}")
    private long jwtExpirationMs;

    // Generate signing key from secret
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // Generate JWT token for a given username
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Get username from JWT token
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // Validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // You can log the error if needed
            return false;
        }
    }
}
