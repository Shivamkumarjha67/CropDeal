package com.major.user_service.service;

import org.springframework.http.ResponseEntity;

import com.major.user_service.dto.DealerDto;

public interface DealerService {
	ResponseEntity<String> updateProfile(String email, DealerDto dealerDto);
}
