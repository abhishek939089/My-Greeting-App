package com.example.greetingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.greetingApp.repository")
public class MyGreetingApplication {

	public static void main(String[] args) {
		System.out.println("Greetings ");
		SpringApplication.run(MyGreetingApplication.class, args);
	}

}
