package com.example.greetingApp.controller;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class greetingController {

    private final GreetingService greetingService;

    public greetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Save a greeting message
    @PostMapping
    public Greeting saveGreeting(@RequestBody Map<String, String> request) {
        return greetingService.saveGreeting(request.get("message"));
    }

    // Get all greeting messages
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
