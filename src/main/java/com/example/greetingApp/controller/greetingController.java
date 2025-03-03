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

    // ✅ UC4 - Save a greeting message
    /*
    curl -X POST http://localhost:8084/greeting -H "Content-Type: application/json" -d '{"message": "Hello, World!"}'
    */
    @PostMapping
    public Greeting saveGreeting(@RequestBody Map<String, String> request) {
        return greetingService.saveGreeting(request.get("message"));
    }

    // ✅ UC4 & UC6 - Get all greeting messages
    /*
    curl -X GET http://localhost:8084/greeting/all
    */
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // ✅ UC5 - Get a greeting message by ID
    /*
    curl -X GET http://localhost:8084/greeting/1
    */
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // ✅ UC7 - Update a greeting message
    /*
    curl -X PUT http://localhost:8084/greeting/1 -H "Content-Type: application/json" -d '{"message": "Hello, Spring Boot!"}'
    */
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> request) {
        return greetingService.updateGreeting(id, request.get("message"));
    }

    // ✅ UC8 - Delete a greeting message
    /*
    curl -X DELETE http://localhost:8084/greeting/1
    */
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        return greetingService.deleteGreeting(id);
    }
}
