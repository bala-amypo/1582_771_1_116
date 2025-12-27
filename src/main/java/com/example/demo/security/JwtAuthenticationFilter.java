// // package com.example.demo.security;

// // import jakarta.servlet.*;
// // import jakarta.servlet.http.*;
// // import org.springframework.security.authentication.*;
// // import org.springframework.security.core.context.SecurityContextHolder;
// // import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// // import org.springframework.stereotype.Component;
// // import org.springframework.web.filter.OncePerRequestFilter;

// // import java.io.IOException;

// // @Component
// // public class JwtAuthenticationFilter extends OncePerRequestFilter {

// //     private final JwtTokenProvider jwtTokenProvider;
// //     private final CustomUserDetailsService userDetailsService;

// //     public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider,
// //                                    CustomUserDetailsService userDetailsService) {
// //         this.jwtTokenProvider = jwtTokenProvider;
// //         this.userDetailsService = userDetailsService;
// //     }

// //     @Override
// //     protected void doFilterInternal(HttpServletRequest request,
// //                                     HttpServletResponse response,
// //                                     FilterChain chain)
// //             throws ServletException, IOException {

// //         String header = request.getHeader("Authorization");

// //         if (header != null && header.startsWith("Bearer ")) {
// //             String token = header.substring(7);
// //             if (jwtTokenProvider.validateToken(token)) {
// //                 String email = jwtTokenProvider.getUsername(token);
// //                 var userDetails = userDetailsService.loadUserByUsername(email);

// //                 UsernamePasswordAuthenticationToken auth =
// //                         new UsernamePasswordAuthenticationToken(
// //                                 userDetails, null, userDetails.getAuthorities());

// //                 auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
// //                 SecurityContextHolder.getContext().setAuthentication(auth);
// //             }
// //         }
// //         chain.doFilter(request, response);
// //     }
// // }

// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;
// import java.util.stream.Collectors;

// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final JwtTokenProvider jwtProvider;

//     public JwtAuthenticationFilter(JwtTokenProvider jwtProvider) {
//         this.jwtProvider = jwtProvider;
//     }

//     @Override
//     protected void doFilterInternal(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             FilterChain filterChain)
//             throws ServletException, IOException {

//         String header = request.getHeader("Authorization");

//         if (header != null && header.startsWith("Bearer ")) {
//             String token = header.substring(7);

//             if (jwtProvider.validateToken(token)) {
//                 var authorities = jwtProvider.getRole(token).stream()
//                     .map(SimpleGrantedAuthority::new)
//                     .collect(Collectors.toList());

//                 UsernamePasswordAuthenticationToken auth =
//                     new UsernamePasswordAuthenticationToken(
//                         jwtProvider.getUsername(token),
//                         null,
//                         authorities);

//                 auth.setDetails(
//                     new WebAuthenticationDetailsSource().buildDetails(request));

//                 SecurityContextHolder.getContext().setAuthentication(auth);
//             }
//         }

//         filterChain.doFilter(request, response);
//     }
// }
package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            if (jwtTokenProvider.validateToken(token)) {

                String email = jwtTokenProvider.getEmailFromToken(token);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                Collections.emptyList()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}

