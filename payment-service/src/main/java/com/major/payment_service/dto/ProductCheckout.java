package com.major.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCheckout {
	private Double amount;
    private Long quantity;
    private String name;
    private String currency;
}