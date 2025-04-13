package com.major.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.major.order_service.dto.CropDto;
import com.major.order_service.dto.StripeResponseHolder;
import com.major.order_service.service.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/home")
	public ResponseEntity<String> home() {
		return new ResponseEntity<>("Welcome into order service..", HttpStatus.OK);
	}
	
	@PostMapping("/product")
	public ResponseEntity<StripeResponseHolder> proceedOrder(@RequestBody CropDto cropDto, @RequestParam Long dealerId, @RequestParam long sellerId) {
		return orderService.proceedOrder(cropDto, dealerId, sellerId);
	}
}