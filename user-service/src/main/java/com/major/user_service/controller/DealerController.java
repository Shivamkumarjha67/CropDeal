package com.major.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.major.user_service.dto.DealerDto;
import com.major.user_service.service.DealerService;

@Controller
@RequestMapping("dealer")
public class DealerController {
	
	@Autowired
	private DealerService dealerService;
	
	@PostMapping("/updateProfile")
	public ResponseEntity<String> updateProfile(@RequestHeader("X-User-Email") String email, @RequestBody DealerDto dealerDto) {
		return dealerService.updateProfile(email, dealerDto);
	}
}
