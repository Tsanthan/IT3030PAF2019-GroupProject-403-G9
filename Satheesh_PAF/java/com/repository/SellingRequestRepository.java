package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.SellingRequestModel;

@Repository
public interface SellingRequestRepository extends JpaRepository<SellingRequestModel, Long> {

}
