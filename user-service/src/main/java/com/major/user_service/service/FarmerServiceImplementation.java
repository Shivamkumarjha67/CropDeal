package com.major.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.major.user_service.dto.CropDto;
import com.major.user_service.dto.FarmerDto;
import com.major.user_service.model.Farmer;
import com.major.user_service.repository.FarmerRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class FarmerServiceImplementation implements FarmerService {
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@Override
	public ResponseEntity<String> updateProfile(String email, FarmerDto farmerDto) {
		log.info("Inside............................");
		Farmer farmer = farmerRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Farmer with email " + email + " not found"));

		farmer.setName(farmerDto.getName());
		farmer.setAccountNumber(farmerDto.getAccountNumber());
		farmer.setAddress(farmerDto.getAddress());
		farmer.setCity(farmerDto.getCity());
		farmer.setPhone(farmerDto.getPhone());
		farmer.setState(farmerDto.getState());

		farmerRepository.save(farmer);
		return new ResponseEntity<>("Your profile updated successfully..", HttpStatus.ACCEPTED);
	}

	@Override
	public Mono<ResponseEntity<String>> addCrop(String email, CropDto crop, String token) {
		Optional<Farmer> farmer = farmerRepository.findByEmail(email);
		Long id = farmer.get().getId();
		
		crop.setFarmerId(id);
		
		return webClientBuilder.build().post()
                .uri("http://api-service/crop/add")
                .header(HttpHeaders.AUTHORIZATION, token)
                .bodyValue(crop)
                .retrieve()
                .toEntity(String.class);
	}

	@Override
	public Mono<ResponseEntity<String>> updateCropDetails(Long id, CropDto cropDto) {
		return webClientBuilder.build().get()
	            .uri("http://api-service/crop/update/{id}", id)
	            .exchangeToMono(clientResponse ->
                	 clientResponse.toEntity(String.class)
	            );
	}

	@Override
	public Mono<ResponseEntity<String>> removeCrop(Long id) {
	    return webClientBuilder.build().get()
	            .uri("http://api-service/crop/remove/{id}", id)
	            .exchangeToMono(clientResponse ->
           	 		clientResponse.toEntity(String.class)
	            );
	}

	@Override
	public Mono<ResponseEntity<List<CropDto>>> getAllCrop(String email) {
		Optional<Farmer> farmer = farmerRepository.findByEmail(email);
		Long id = farmer.get().getId();
		
		log.info("Into farmer get all crop service .................................... " + id);
		
		List<CropDto> cropList = webClientBuilder.build()
			    .get()
			    .uri("http://api-service/crop/getAllCropOfFarmer/{id}", id)
			    .retrieve()
			    .bodyToFlux(CropDto.class)
			    .onErrorResume(ex -> {
			        log.error("Failed to fetch crops for farmer: {}", id, ex);
			        return Flux.empty();
			    })
			    .collectList()
			    .block();
		
		log.info("--------------------          Crop list is: " + cropList);

		return Mono.just(ResponseEntity.ok(cropList));
	}

	@Override
	public Mono<ResponseEntity<String>> home(String token) {
		return webClientBuilder.build().get()
				.uri("http://api-service/crop/home")
	            .header(HttpHeaders.AUTHORIZATION, token)
	            .exchangeToMono(clientResponse ->
           	 		clientResponse.toEntity(String.class));
	            
	}
}