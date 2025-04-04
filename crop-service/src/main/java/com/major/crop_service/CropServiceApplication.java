package com.major.crop_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CropServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CropServiceApplication.class, args);
		System.out.println("Crop service running on 9070....");
	}
}