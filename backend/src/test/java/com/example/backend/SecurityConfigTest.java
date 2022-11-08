package com.example.backend;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
/*
class SecurityConfigTest {

    @Test
    void whenEmployeeAnd() {
        //given
        String username = "Hans";
        String rawPassword = "test123";
        String encodedTestPassword = new BCryptPasswordEncoder().encode(rawPassword);
        System.out.println(encodedTestPassword);

        // when
        SecurityConfig securityConfig = new SecurityConfig();
        securityConfig.hansPassword = encodedTestPassword;
        securityConfig.franzPassword = "blödsinn";
        String actual = securityConfig.inMemoryUserDetailsManager()
                .loadUserByUsername(username)
                .getPassword();

        // then
        assertTrue(securityConfig.encoder().matches(rawPassword, actual));
    }
}
 */