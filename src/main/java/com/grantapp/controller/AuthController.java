package com.grantapp.controller;

import com.grantapp.model.CarsUser;
import com.grantapp.repository.CarsUserRepository;
import com.grantapp.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private CarsUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String username = credentials.get("username");
            String password = credentials.get("password");
            System.out.println(username);
            System.out.println(passwordEncoder.encode(password));

            // Find user by username
            CarsUser user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            System.out.println(user.getId().toString());

            // Validate password
            Boolean isMatch = passwordEncoder.matches(password, user.getPassword());
            System.out.println(isMatch);
            if (!isMatch) {
                throw new RuntimeException("Invalid password");
            }
            //System.out.println(passwordEncoder.matches(password, user.getPassword());
            // Generate JWT token
            String token = jwtTokenProvider.createToken(username);

            // Return the token in the response
            Map<String, String> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            response.put("carsuserid", user.getId().toString()); // Include the user ID in the response

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception for debugging
            System.err.println("Error during login: " + e.getMessage());
            e.printStackTrace();

            // Return a 500 error with the exception message
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}