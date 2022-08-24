package com.codify.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

	@GetMapping()
	public  ResponseEntity<String> greeting() {
		return  ResponseEntity.ok("Hello ! This is Spring Boot API Demo App.");
	}

	@GetMapping("/hello")
    ResponseEntity<String> sayHello(@RequestParam(value = "name") String name) {
		return  ResponseEntity.ok("Hello " + name);
	}

}
