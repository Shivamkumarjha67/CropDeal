package com.major.crop_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.major.crop_service.model.CropItems;
import com.major.crop_service.service.CropService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("crop")
@Slf4j
public class CropController {
	
	@Autowired
	private CropService cropService;
	
	@GetMapping("home")
	public ResponseEntity<String> home() {
		return new ResponseEntity<>("Welcome to the crop service..", HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addCrop(@RequestBody CropItems crop) {
		return cropService.addCrop(crop);
	}
	
	@GetMapping("allCrop")
	public ResponseEntity<List<CropItems>> getAllCrop() {
		return cropService.getAllCrop();
	}
	
	@PutMapping("update/{id}") 
	public ResponseEntity<String> updateDetail(@PathVariable Long id, @RequestBody CropItems cropItems) {
		return cropService.updateCropDetails(id, cropItems);
	}
	
	@GetMapping("remove/{id}")
	public ResponseEntity<String> removeCrop(@PathVariable Long id) {
		return cropService.removeCrop(id);
	}
	
	@GetMapping("getAllSoldCrop") 
	public ResponseEntity<List<Long>> getAllSoldCrop() {
		return cropService.getSoldCrop();
	}
	
	// Getting the crop with given farmerId
	@GetMapping("allCropOfFarmer") 
	public ResponseEntity<List<CropItems>> getAllCropOfFarmer(@RequestParam("id") Long farmerId) {
		return cropService.getAllCropOfFarmer(farmerId);
	}
}
