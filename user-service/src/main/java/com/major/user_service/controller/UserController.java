package com.major.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.major.user_service.dto.UserDto;
import com.major.user_service.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<>("Welcome home...", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
		if(userDto.getName() == null || userDto.getEmail() == null || userDto.getPassword() == null) {
			return new ResponseEntity<>("Name, Email and Password field can not be empty. Fill it first." ,HttpStatus.BAD_REQUEST);
		}
		
		return userService.registerUser(userDto);
	}
	
	// @PreAuthorize("hasAnyRole('Farmer', 'Dealer')")
	@GetMapping("/login") 
	public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
		log.info("entered--------------");
		String token = userService.loginUser(email, password);
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
}