package com.example.greetingApp.controller;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class greetingController {

    private final GreetingService greetingService;

    public greetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Retrieve a greeting by ID
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
}
