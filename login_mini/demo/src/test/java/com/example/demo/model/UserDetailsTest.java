package com.example.demo.model;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDetailsTest {

    @Test
    public void testUserDetails() {
        // Create a User instance
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        // Test UserDetails methods
        UserDetails userDetails = user;

        assertEquals("testuser", userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().isEmpty()); // No roles defined
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertTrue(userDetails.isEnabled());
    }

    @Test
    public void testRegister(){
        User user = new User();
    }
}
