package com.major.crop_service.model;

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