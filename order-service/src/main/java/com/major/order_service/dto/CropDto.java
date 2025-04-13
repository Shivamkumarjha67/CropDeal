package com.major.order_service.dto;

import lombok.Data;

@Data
public class CropDto {
    private Long id;
    private Long farmerId;
    private String cropType;
    private String cropName;
    private Long quantity;
    private double unitPrice;
    private String status;
    private String location;
}