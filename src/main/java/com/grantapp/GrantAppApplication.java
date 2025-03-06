package com.grantapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Enable JPA Auditing

public class GrantAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrantAppApplication.class, args);
    }
}