package com.example.greetingApp.controller;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class greetingController {  // ✅ Fixed class name (PascalCase)

    private final GreetingService greetingService;

    public greetingController(GreetingService greetingService) {  // ✅ Fixed constructor name
        this.greetingService = greetingService;
    }

    // ✅ UC4 - Save a greeting message
    @PostMapping
    public Greeting saveGreeting(@RequestBody Map<String, String> request) {
        return greetingService.saveGreeting(request.get("message"));  // ✅ Method name corrected
    }

    // ✅ UC4 & UC6 - Get all greeting messages
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // ✅ UC5 - Get a greeting message by ID
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // ✅ UC7 - Update a greeting message
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> request) {
        return greetingService.updateGreeting(id, request.get("message"));  // ✅ Method name corrected
    }

    // ✅ UC8 - Delete a greeting message
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        return greetingService.deleteGreeting(id);  // ✅ Method name corrected
    }
}
