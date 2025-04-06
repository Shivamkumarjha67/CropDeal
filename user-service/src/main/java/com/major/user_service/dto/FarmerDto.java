package com.major.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerDto {

	private String name;
	private String accountNumber;
	private String address;
	private String state;
	private String city;
	private int phone;
	
	private String token;
}