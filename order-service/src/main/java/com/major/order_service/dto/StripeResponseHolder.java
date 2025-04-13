package com.major.order_service.dto;

import lombok.Data;

@Data
public class StripeResponseHolder {
    private String status;
    private String message;
    private String sessionId;
    private String sessionUrl;
}