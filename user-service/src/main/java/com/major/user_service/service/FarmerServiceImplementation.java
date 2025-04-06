package com.major.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.major.user_service.dto.FarmerDto;
import com.major.user_service.repository.FarmerRepository;

@Service
public class FarmerServiceImplementation implements FarmerService {
	
	@Autowired
	private FarmerRepository farmerRepository;

	@Override
	public ResponseEntity<String> updateProfile(FarmerDto farmerDto, String email) {
		return null;
	}
}