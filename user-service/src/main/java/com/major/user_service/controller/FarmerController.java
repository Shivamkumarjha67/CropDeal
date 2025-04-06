package com.major.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.major.user_service.dto.FarmerDto;
import com.major.user_service.service.FarmerService;

@Controller
@RequestMapping("farmer")
public class FarmerController {
	
	@Autowired
	private FarmerService farmerService;

//	@PostMapping("/updateProfile")
//	public ResponseEntity<String> updateProfile(@RequestBody FarmerDto farmerDto) {
//		return farmerService.updateProfile(farmerDto);
//	}
}