package com.major.crop_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.major.crop_service.model.CropItems;

public interface CropRepository extends JpaRepository<CropItems, Long> {
	@Query("SELECT c.id FROM CropItems c WHERE c.status = :status")
	List<Long> getSoldCrop(String status);
	
	@Query("Select c FROM CropItems c WHERE c.farmerId = :farmerId")
	List<CropItems> findByFarmerId(@Param("farmerId") Long farmerId);
}