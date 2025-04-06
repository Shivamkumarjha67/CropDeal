package com.major.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.major.user_service.model.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

}
