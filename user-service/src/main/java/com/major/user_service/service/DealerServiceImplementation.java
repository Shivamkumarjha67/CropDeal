package com.major.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.major.user_service.dto.DealerDto;
import com.major.user_service.model.Dealer;
import com.major.user_service.repository.DealerRepository;

@Service
public class DealerServiceImplementation implements DealerService {

	@Autowired
	private DealerRepository dealerRepository;

	@Override
	public ResponseEntity<String> updateProfile(String email, DealerDto dealerDto) {
		Dealer dealer = dealerRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Dealer with email " + email + " not found"));

		dealer.setName(dealerDto.getName());
		dealer.setAccountNumber(dealerDto.getAccountNumber());
		dealer.setAddress(dealerDto.getAddress());
		dealer.setCity(dealerDto.getCity());
		dealer.setPhone(dealerDto.getPhone());
		dealer.setState(dealerDto.getState());

		dealerRepository.save(dealer);
		return new ResponseEntity<>("Your profile updated successfully..", HttpStatus.ACCEPTED);
	}
}
