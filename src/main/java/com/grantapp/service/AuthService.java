package com.grantapp.service;

import com.grantapp.model.CarsUser;
import com.grantapp.repository.CarsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private CarsUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String username, String password) {
        CarsUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return "JWT_TOKEN"; // Replace with actual JWT token generation
        }
        throw new RuntimeException("Invalid credentials");
    }

    public CarsUser signup(CarsUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}