package com.example.demo.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

//@Entity
public class CustomUserDetails implements UserDetails {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String username;
//    private String password;
    private final User user;

    public CustomUserDetails(User user){
        this.user = user;
    }

    private static final Log logger = LogFactory.getLog(CustomUserDetails.class);

    // Getters and Setters

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // For simplicity, no roles are defined
        return user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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


}
