package com.example.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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


/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
}*/



    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
    return new InMemoryUserDetailsManager(
                User.builder()
                        .username("Hans")
                        .password("$2a$10$Bl9WGgbbc8VF3pJ1C6/VDevfzJ1rQF3vyanjLq24vrNAexUyoRjkS")
                        .roles("Employee")
                        .build()
        );
    }

    // For error message:
    // java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    // 1234abcd!
//    public static void main(String[] args) {
//        String username = new BCryptPasswordEncoder().encode("Hans");
//        System.out.println(username);
//    }

   //  https://www.javainuse.com/onlineBcrypt
}


