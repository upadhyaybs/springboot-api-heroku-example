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
	public  ResponseEntity<Map<String,Map<String,String>>> greeting() {
		Map<String,String> responseData=new HashMap<>();
		responseData.put("response","Hello ! This is Spring Boot API Demo App.");
		responseData.put("version","1.0");
		responseData.put("createdTimestamp",new Date().toString());

		Map<String,Map<String,String>> response=new HashMap<>();
		response.put("response",responseData);
		return  ResponseEntity.ok(response);
	}

	@GetMapping("/hello")
    ResponseEntity<String> sayHello(@RequestParam(value = "name") String name) {
		return  ResponseEntity.ok("Hi " + name + " : responded on - " + new Date());
	}

}
