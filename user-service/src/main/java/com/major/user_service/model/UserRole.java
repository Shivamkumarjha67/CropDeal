package com.major.user_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
	ADMIN, FARMER, DEALER;
	
	@JsonValue
	public String toValue() {
		return this.name();
	}
	
	@JsonCreator
	public static UserRole fromValue(String role) {
		return UserRole.valueOf(role.toUpperCase());
	}
}
