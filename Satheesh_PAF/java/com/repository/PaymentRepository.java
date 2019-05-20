package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.PaymentModel;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {

}
