package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // Getters and Setters

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // For simplicity, no roles are defined
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Indicate that the account is not expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Indicate that the account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Indicate that the credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Indicate that the account is enabled
    }

    // Getters and Setters for id, username, and password

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
