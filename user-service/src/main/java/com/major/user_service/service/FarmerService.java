package com.major.user_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.major.user_service.dto.CropDto;
import com.major.user_service.dto.FarmerDto;

import reactor.core.publisher.Mono;

public interface FarmerService {
	ResponseEntity<String> updateProfile(String email, FarmerDto farmerDto);

	Mono<ResponseEntity<String>> addCrop(String email, CropDto crop, String token);

	Mono<ResponseEntity<String>> updateCropDetails(Long id, CropDto cropDto);

	Mono<ResponseEntity<String>> removeCrop(Long id);

	Mono<ResponseEntity<List<CropDto>>> getAllCrop(String email);

	Mono<ResponseEntity<String>> home(String token);
}