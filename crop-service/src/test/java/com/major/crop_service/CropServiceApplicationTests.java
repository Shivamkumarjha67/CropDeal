package com.major.crop_service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.major.crop_service.controller.CropController;
import com.major.crop_service.model.CropItems;
import com.major.crop_service.model.CropStatus;
import com.major.crop_service.repository.CropRepository;

@SpringBootTest
class CropServiceApplicationTests {
	@Autowired
    private CropRepository repository;
	
	@Autowired
	private CropController cropController;

    @Test
    void checkCropAdding() {
    	
    	CropItems crop = new CropItems();
        crop.setFarmerId(101L);
        crop.setCropType("Vegetable");
        crop.setCropName("Broccoli");
        crop.setQuantity(45.50);
        crop.setUnitPrice(new BigDecimal("20.0"));
        crop.setStatus(CropStatus.AVAILABLE);
        crop.setLocation("Bhopal");
        
        
    	
    	assertNotNull(repository.save(crop));
    }
}