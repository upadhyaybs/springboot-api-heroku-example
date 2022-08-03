package com.codify.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.codify.demo")
public class SpringBootApiHerokuDemo {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiHerokuDemo.class, args);
	}

}
