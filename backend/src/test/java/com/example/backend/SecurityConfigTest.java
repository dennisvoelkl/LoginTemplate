package com.example.backend;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigTest {

    @Test
    void inMemoryUserDetailsManager() {
        SecurityConfig securityConfig = new SecurityConfig();
        String username = "Hans";
        String rawPassword = "test123";
        String encodedTestPassword = new BCryptPasswordEncoder().encode(rawPassword);
        String encodedPassword = securityConfig.inMemoryUserDetailsManager()
                        .loadUserByUsername(username)
                                .getPassword();
        assertTrue(securityConfig.encoder().matches(rawPassword, encodedTestPassword));
    }
}