package com.major.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
	private String name;
	private String email;
	private String password;
	
	private String role;
}