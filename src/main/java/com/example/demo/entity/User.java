package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "users")
public class User {
     @Id @GeneratedValue
    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    
    @ElementCollection
    private Set<String> roles;
    private LocalDateTime createdAt;
    public User(){
        
    }
    public User(String password, Set<String> roles, LocalDateTime createdAt) {
        this.password = password;
        this.roles = roles;
        this.createdAt = createdAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    public long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
   
}
