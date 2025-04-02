package com.major.crop_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.major.crop_service.model.CropItems;
import com.major.crop_service.service.CropService;

@Controller
@RequestMapping("crop")
public class Crop_controller {
	
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
}
