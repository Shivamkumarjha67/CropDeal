package com.major.crop_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.major.crop_service.model.CropItems;
import com.major.crop_service.repository.CropRepository;

@Service
public class CropService {
	
	@Autowired
	private CropRepository cropRepository;

	public ResponseEntity<String> addCrop(CropItems crop) {
		cropRepository.save(crop);
		return new ResponseEntity<>("Saved the detail of crop successfully.", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<CropItems>> getAllCrop() {
		return new ResponseEntity<List<CropItems>>(cropRepository.findAll(), HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> updateCropDetails(Long id, CropItems crop) {
		Optional<CropItems> cropItem = cropRepository.findById(id);
		if(cropItem.isEmpty()) return new ResponseEntity<>("Crop item is not present", HttpStatus.BAD_REQUEST);
		cropRepository.save(crop);
		
		return new ResponseEntity<>("Details of the crop is updated.", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> removeCrop(Long id) {
		if(!cropRepository.existsById(id)) return new ResponseEntity<>("Crop with given id does not exists.", HttpStatus.BAD_REQUEST);
		cropRepository.deleteById(id);
		
		return new ResponseEntity<>("Crop removed from database.", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<Long>> getSoldCrop() {
		List<Long> idsList = cropRepository.getSoldCrop("SOLD");
		
		return new ResponseEntity<List<Long>>(idsList, HttpStatus.ACCEPTED);
	}
}
