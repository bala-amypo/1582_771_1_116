package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data // This generates getEmail(), getPassword(), etc.
@NoArgsConstructor
@AllArgsConstructor
@Builder // This generates the builder() method
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;
}