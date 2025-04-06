package com.major.user_service.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.major.user_service.dto.UserDto;
import com.major.user_service.model.User;
import com.major.user_service.repository.UserRepository;
import com.major.user_service.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public ResponseEntity<String> registerUser(UserDto userDto) {
		if(userRepository.existsByEmail(userDto.getEmail())) {
			return new ResponseEntity<String>("User is already registered by the email provided!", HttpStatus.BAD_REQUEST);
		}
		
		User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(userDto.getRole() == null ? "FARMER" : userDto.getRole().toUpperCase())
                .status("ACTIVE")
                .build();
		
		userRepository.save(user);
		
		return new ResponseEntity<String>("User registered successfully...", HttpStatus.OK);
	}

	@Override
	public String loginUser(String email, String password) {
		if(!userRepository.existsByEmail(email)) return "User not registered";
		Optional<User> user = userRepository.findByEmail(email);

		String fetchedPassword = user.get().getPassword();
		
		if(!passwordEncoder.matches(password, fetchedPassword)) {
			return "Invalid password";
		}

        return jwtUtil.generateToken(user.get().getEmail(), user.get().getRole());		
	}
}