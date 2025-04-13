package com.major.order_service.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.major.order_service.dto.CropDto;
import com.major.order_service.dto.InvoiceModel;
import com.major.order_service.dto.StripeRequest;
import com.major.order_service.dto.StripeResponseHolder;
import com.major.order_service.feign.PaymentInterface;
import com.major.order_service.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private PaymentInterface paymentInterface;

	@Override
	public ResponseEntity<StripeResponseHolder> proceedOrder(CropDto cropDto, Long dealerId, Long sellerId) {
		StripeRequest request = StripeRequest.builder()
				.name(cropDto.getCropName())
				.amount(cropDto.getUnitPrice())
				.quantity(cropDto.getQuantity())
				.currency("INR")
				.build();
		
		ResponseEntity<StripeResponseHolder> response = paymentInterface.checkoutProducts(request);
		
		if(response.getStatusCode() == HttpStatus.OK) {
			double totalAmount = cropDto.getUnitPrice() * cropDto.getQuantity();
			
			InvoiceModel invoice = InvoiceModel.builder()
					.cropName(cropDto.getCropName())
					.quantity(cropDto.getQuantity())
					.unitPrice(cropDto.getUnitPrice())
					.totalAmount(totalAmount)
					.date(LocalDate.now())
					.dealerId(dealerId)
					.sellerId(sellerId)
					.build();
			
			orderRepository.save(invoice);
			
			String message = response.getBody().getMessage() + " and also saved the invoice in DB.";
			response.getBody().setMessage(message);
		}
		
		return response;
	}

}