package com.major.order_service.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class InvoiceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	
	private Long dealerId;
	private Long quantity;
	private double unitPrice;
	private double totalAmount;
	private Long sellerId;
	private String cropName;
	private LocalDate date;
}