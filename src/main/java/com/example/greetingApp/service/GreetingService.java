package com.example.greetingApp.service;

import org.springframework.stereotype.Service;

@Service // Marks this as a service component
public class GreetingService {

    public String getGreetingMessage() {
        return "Hello World";
    }
}
