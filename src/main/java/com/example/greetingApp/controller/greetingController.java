package com.example.greetingApp.controller;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class greetingController {

    private final GreetingService greetingService;

    public greetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Save a greeting message (UC4)
    @PostMapping
    public Greeting saveGreeting(@RequestBody Map<String, String> request) {
        return greetingService.saveGreeting(request.get("message"));
    }

    // Get all greeting messages (UC4)
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // Get a greeting message by ID (UC5)
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // ✅ UC7 - Update a greeting message
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> request) {
        return greetingService.updateGreeting(id, request.get("message"));
    }
}
