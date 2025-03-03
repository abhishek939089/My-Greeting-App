package com.example.greetingApp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // Marks this class as a REST controller
@RequestMapping("/greeting") // Base URL for all endpoints in this controller
public class greetingController {

    /**
     * Handles HTTP GET requests.
     * GET is used to retrieve information from the server.
     * Example: Fetch a greeting message.
     *
     * @return A JSON response containing a greeting message.
     */
    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a GET request!");
        return response;
    }

    /**
     * Handles HTTP POST requests.
     * POST is used to send data to the server to create a new resource.
     * Example: Sending a greeting message with request data.
     *
     * @param request A JSON payload containing user input.
     * @return A JSON response with the received data and confirmation message.
     */
    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a POST request!");
        response.put("received", request.toString()); // Echoing received input
        return response;
    }

    /**
     * Handles HTTP PUT requests.
     * PUT is used to update an existing resource or create it if it doesn't exist.
     * Example: Updating a greeting message.
     *
     * @param request A JSON payload containing updated user input.
     * @return A JSON response with the updated data and confirmation message.
     */
    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a PUT request!");
        response.put("received", request.toString()); // Echoing received input
        return response;
    }

    /**
     * Handles HTTP DELETE requests.
     * DELETE is used to remove a resource from the server.
     * Example: Deleting a greeting message.
     *
     * @return A JSON response confirming deletion.
     */
    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a DELETE request!");
        return response;
    }
}
