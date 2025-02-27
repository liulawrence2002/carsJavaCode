package com.grantapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Allow access to auth endpoints
                        .requestMatchers("/api/institutions/**").permitAll() // Allow access to institutions endpoints
                        .requestMatchers("/api/funding-opportunities/**").permitAll() // Allow access to funding opportunities endpoints
                        .requestMatchers("/api/news/**").permitAll() // Allow access to funding opportunities endpoints
                        .requestMatchers("/api/grant-applications/**").permitAll() // Allow access to funding opportunities endpoints
                        .anyRequest().authenticated() // Require authentication for all other requests
                /*).oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(new JwtAuthenticationConverter())
                        )*/
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}