package com.major.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.major.user_service.model.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}
