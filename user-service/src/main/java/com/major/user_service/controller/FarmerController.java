package com.major.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.major.user_service.dto.CropDto;
import com.major.user_service.dto.FarmerDto;
import com.major.user_service.service.FarmerService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("farmer")
@Slf4j
public class FarmerController {
	
	@Autowired
	private FarmerService farmerService;

	@PostMapping("/updateProfile")
	public ResponseEntity<String> updateProfile(@RequestHeader("X-User-Email") String email, @RequestBody FarmerDto farmerDto) {
		log.info("In controller............................" + email);
		return farmerService.updateProfile(email, farmerDto);
	}
	
	@PostMapping("addCrop")
	public Mono<ResponseEntity<String>> addCrop(@RequestHeader("X-User-Email") String email, @RequestBody CropDto crop, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
		return farmerService.addCrop(email, crop, token);
	}
	
	@GetMapping("cropHome")
	public Mono<ResponseEntity<String>> home(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
		return farmerService.home(token);
	}
	
	@GetMapping("allCrop")
	public Mono<ResponseEntity<List<CropDto>>> getAllCrop(@RequestHeader("X-User-Email") String email) {
		log.info("Into all crop...");
		return farmerService.getAllCrop(email);
	}
	
	@PutMapping("updateCrop/{id}") 
	public Mono<ResponseEntity<String>> updateCropDetails(@PathVariable Long id, @RequestBody CropDto cropDto) {
		return farmerService.updateCropDetails(id, cropDto);
	}
	
	@GetMapping("removeCrop/{id}")
	public Mono<ResponseEntity<String>> removeCrop(@PathVariable Long id) {
		return farmerService.removeCrop(id);
	}
}