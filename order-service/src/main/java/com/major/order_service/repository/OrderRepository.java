package com.major.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.major.order_service.dto.InvoiceModel;

public interface OrderRepository extends JpaRepository<InvoiceModel, Long> {

}
