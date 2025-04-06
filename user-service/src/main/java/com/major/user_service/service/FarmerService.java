package com.major.user_service.service;

import org.springframework.http.ResponseEntity;

import com.major.user_service.dto.FarmerDto;

public interface FarmerService {
	ResponseEntity<String> updateProfile(FarmerDto farmerDto, String email);
}