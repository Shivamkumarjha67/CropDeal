package com.major.user_service.dto;


import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CropDto {
	private Long id;
    private Long farmerId;
    private String cropType;
    private String cropName;
    private double quantity;
    private BigDecimal unitPrice;
    private String status;
    private String location;
}