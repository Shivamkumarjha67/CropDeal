package com.major.crop_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.major.crop_service.model.CropItems;

public interface CropRepository extends JpaRepository<CropItems, Long> {

}
