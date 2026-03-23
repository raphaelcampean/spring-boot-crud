package com.crud.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Adicione este import
import org.springframework.security.web.SecurityFilterChain; // Adicione este import
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita o CSRF (necessário para APIs e testes via Postman/ApiDog)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Libera todos os caminhos para teste sem login
            );
        return http.build();
    }
}