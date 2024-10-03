package com.example.springgradle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeProjectGradleApplication {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeProjectGradleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectGradleApplication.class, args);
		System.out.println("Hello World");
	}

}
