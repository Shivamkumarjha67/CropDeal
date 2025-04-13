package com.major.order_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StripeRequest {
	private Double amount;
    private Long quantity;
    private String name;
    private String currency;
}