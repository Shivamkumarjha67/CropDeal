package com.major.order_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.major.order_service.dto.StripeRequest;
import com.major.order_service.dto.StripeResponseHolder;

@FeignClient("PAYMENT-SERVICE")
public interface PaymentInterface {

    @PostMapping("checkout/product")
    public ResponseEntity<StripeResponseHolder> checkoutProducts(@RequestBody StripeRequest request);
}