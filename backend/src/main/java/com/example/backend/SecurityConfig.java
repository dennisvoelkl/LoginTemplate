package com.example.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers("/api/team").authenticated()
                .and().build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Value("${app.user.hans.password}")
    private String hansPassword;
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
    return new InMemoryUserDetailsManager(
                User.builder()
                        .username("Hans")
                        .password(hansPassword)
                        .roles("Employee")
                        .build()
        );
    }
}


