package com.example.greetingApp.service;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // Save a new greeting
    public Greeting saveGreeting(String message) {
        return greetingRepository.save(new Greeting(message));
    }

    // Retrieve all greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
