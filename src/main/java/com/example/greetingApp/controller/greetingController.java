package com.example.greetingApp.controller;

import com.example.greetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class greetingController {

    private final GreetingService greetingService;

    public greetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET - Handle different user attributes for greeting
    @GetMapping
    public Map<String, String> getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }
}
