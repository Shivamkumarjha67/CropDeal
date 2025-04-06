package com.major.user_service.service;

import org.springframework.http.ResponseEntity;

import com.major.user_service.dto.UserDto;

public interface UserService {
	public ResponseEntity<String> registerUser(UserDto userDto);
	public String loginUser(String email, String password);
}
