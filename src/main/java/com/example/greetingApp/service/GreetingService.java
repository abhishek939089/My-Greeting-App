package com.example.greetingApp.service;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // ✅ UC2 - Simple greeting message
    public String getGreetingMessageUC2() {
        return "Hello from GreetingService!";
    }

    // ✅ UC3 - Personalized greeting message
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }

    // ✅ Save a greeting message
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    // ✅ Get a greeting by ID
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // ✅ Get all greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // ✅ Update a greeting message
    public Greeting updateGreeting(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found.");
        }
    }

    // ✅ Delete a greeting message
    public String deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return "Greeting deleted successfully.";
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found.");
        }
    }
}
