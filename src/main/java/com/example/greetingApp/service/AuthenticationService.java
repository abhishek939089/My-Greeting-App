package com.example.greetingApp.service;

import com.example.greetingApp.model.AuthUser;
import com.example.greetingApp.repository.AuthUserRepository;
import com.example.greetingApp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired(required=true)
    private JwtUtil jwtUtil;

    @Autowired
    private EmailService emailService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Register User
    public String registerUser(AuthUser authUser) {
        if (authUserRepository.existsByEmail(authUser.getEmail())) {
            return "Email is already in use!";
        }

//        AuthUser user = new AuthUser();
//        user.setFirstName(authUser.getFirstName());
//        user.setLastName(authUser.getLastName());
//        user.setEmail(authUser.getEmail());
//        user.setPassword(passwordEncoder.encode(authUser.getPassword())); // Encrypt password
        authUserRepository.save(authUser);
        emailService.sendSimpleEmail(authUser.getEmail(), "Registration Status", "You are registered successfully! Regards,BridgeLabz");
        return "User registered successfully! A confirmation email has been sent from BridgeLabz.";
    }

    // Authenticate User and Generate Token
    public String authenticateUser(String email, String password) {
        Optional<AuthUser> userOpt = authUserRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            return "User not found!";
        }

        AuthUser user = userOpt.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid email or password!";
        }

        // Generate JWT Token using HMAC256
        return jwtUtil.generateToken(email);
    }
}
