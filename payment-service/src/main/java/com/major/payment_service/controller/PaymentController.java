package com.major.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.major.payment_service.dto.ProductCheckout;
import com.major.payment_service.dto.StripeResponse;
import com.major.payment_service.service.StripeService;

@RestController
@RequestMapping("/checkout")
public class PaymentController {
	
	@Autowired
	private StripeService stripeService;

    @PostMapping("/product")
    public ResponseEntity<StripeResponse> checkoutProducts(@RequestBody ProductCheckout productCheckout) {
        StripeResponse stripeResponse = stripeService.checkoutProducts(productCheckout);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stripeResponse);
    }
}