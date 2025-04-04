package com.major.api_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
		System.out.println("Api Gateway is running on 8766....");
	}
}