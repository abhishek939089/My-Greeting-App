package com.example.greetingApp.controller;

import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class greetingController {

    private final GreetingService greetingService;

    // Constructor-based Dependency Injection
    public greetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET - Retrieve greeting message from Service Layer
    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage());
        return response;
    }
}
