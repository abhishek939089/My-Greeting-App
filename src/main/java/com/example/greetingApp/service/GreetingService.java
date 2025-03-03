package com.example.greetingApp.service;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Save a new greeting (UC4)
    public Greeting saveGreeting(String message) {
        return greetingRepository.save(new Greeting(message));
    }

    // ✅ UC4 & UC6 - Retrieve all greetings from the repository
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Retrieve a greeting message by ID (UC5)
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // ✅ UC7 - Update a greeting message
    public Greeting updateGreeting(Long id, String newMessage) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            Greeting greeting = optionalGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return null; // Return null if the greeting with the given ID does not exist
    }
}
