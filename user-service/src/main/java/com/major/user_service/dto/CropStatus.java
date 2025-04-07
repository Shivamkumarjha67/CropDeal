package com.major.user_service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CropStatus {
    AVAILABLE, SOLD, EXPIRED;

    @JsonCreator
    public static CropStatus fromValue(String value) {
        return CropStatus.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}