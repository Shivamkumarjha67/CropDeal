package com.major.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.major.user_service.model.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {
	Optional<Farmer> findByEmail(String email);
	boolean existsByEmail(String email);
}