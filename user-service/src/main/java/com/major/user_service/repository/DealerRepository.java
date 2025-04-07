package com.major.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.major.user_service.model.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
	Optional<Dealer> findByEmail(String email);
	boolean existsByEmail(String email);
}