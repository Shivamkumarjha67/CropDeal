package com.major.order_service.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.major.order_service.dto.CropDto;
import com.major.order_service.dto.StripeResponseHolder;

@Component
public interface OrderService {

	ResponseEntity<StripeResponseHolder> proceedOrder(CropDto cropDto, Long dealerId, Long sellerId);

}