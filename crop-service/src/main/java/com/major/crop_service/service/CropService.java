package com.major.crop_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.major.crop_service.model.CropItems;
import com.major.crop_service.repository.CropRepository;

@Service
public class CropService {
	
	@Autowired
	private CropRepository repository;

	public ResponseEntity<String> addCrop(CropItems crop) {
		repository.save(crop);
		return new ResponseEntity<>("Saved the detail of crop successfully.", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<CropItems>> getAllCrop() {
		return new ResponseEntity<List<CropItems>>(repository.findAll(), HttpStatus.ACCEPTED);
	}

}
