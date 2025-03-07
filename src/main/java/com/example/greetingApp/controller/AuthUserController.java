package com.example.greetingApp.controller;

import com.example.greetingApp.model.AuthUser;
import com.example.greetingApp.repository.AuthUserRepository;
import com.example.greetingApp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthUserRepository authUserRepository;

    // Register User
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthUser authUser) {
        String response = authenticationService.registerUser(authUser);
        return ResponseEntity.ok(response);
    }

    // Login User and Generate JWT Token
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> request) {
        String token = authenticationService.authenticateUser(
                request.get("email"),
                request.get("password")
        );

        if (token.equals("User not found!") || token.equals("Invalid email or password!")) {
            return ResponseEntity.status(401).body(Map.of("error", token));
        }

        return ResponseEntity.ok(Map.of("message", "Login successful!", "token", token));
    }

    // ✅ Get User Details by Email
    @GetMapping("/userDetails/{email}")
    public ResponseEntity<?> getUserDetails(@PathVariable String email) {
        Optional<AuthUser> userOpt = authUserRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with email: " + email);
        }

        return ResponseEntity.ok(userOpt.get());
    }
}
