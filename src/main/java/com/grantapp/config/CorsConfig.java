package com.grantapp.config; // Adjust the package name to match your project

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                System.out.println("CORS configuration applied!"); // Add logging
                registry.addMapping("/api/**") // Allow CORS for all endpoints under /api
                        .allowedOrigins("http://localhost:3000") // Replace with your frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
                        .allowedHeaders("*") // Allowed headers
                        .allowCredentials(true); // Allow credentials (e.g., cookies)
            }
        };
    }
}