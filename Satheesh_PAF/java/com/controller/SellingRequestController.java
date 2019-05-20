package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundExceptionClass;
import com.model.SellingRequestModel;
import com.repository.SellingRequestRepository;

@RestController
@RequestMapping("/api")
public class SellingRequestController {

	@Autowired
	SellingRequestRepository sellingRequestRepository;
	
	// Get All Selling Requests
	@GetMapping("/selling_requests")
	public List<SellingRequestModel> getAllSellingRequests() {
	    return sellingRequestRepository.findAll();
	}
	
	// Create a new Selling Request
	@PostMapping("/selling_requests")
	public SellingRequestModel createSellingRequest(@Valid @RequestBody SellingRequestModel sellingRequest) {
	    return sellingRequestRepository.save(sellingRequest);
	}
	
	// Get a Single Selling Request
	@GetMapping("/selling_requests/{request_id}")
	public SellingRequestModel getISellingRequestById(@PathVariable(value = "request_id") Long requestID) {
	    return sellingRequestRepository.findById(requestID)
	            .orElseThrow(() -> new ResourceNotFoundExceptionClass("selling_request", "request_id", requestID));
	}
	
	// Update a Selling Requests
	@PutMapping("/selling_requests/{request_id}")
	public SellingRequestModel updateSellingRequestModel(@PathVariable(value = "request_id") Long requestID,
	                                        @Valid @RequestBody SellingRequestModel sellingRequestDetails) {
		SellingRequestModel sellingRequest = sellingRequestRepository.findById(requestID)
				.orElseThrow(() -> new ResourceNotFoundExceptionClass("selling_request", "request_id", requestID));
	    
		sellingRequest.setFkInvoiceNo(sellingRequest.getFkInvoiceNo());
		sellingRequest.setStatus(sellingRequest.getStatus());
		sellingRequest.setDateTime(sellingRequest.getDateTime());
		sellingRequest.setFkUserID(sellingRequest.getFkUserID());
		SellingRequestModel sellingRequestModel = sellingRequestRepository.save(sellingRequest);
		return sellingRequestModel;
	}
	
	// Delete a Selling Requests
	@DeleteMapping("/selling_requests/{request_id}")
	public ResponseEntity<?> deleteSellingRequestModel(@PathVariable(value = "request_id") Long requestID) {
		SellingRequestModel sellingRequest = sellingRequestRepository.findById(requestID)
				.orElseThrow(() -> new ResourceNotFoundExceptionClass("selling_request", "request_id", requestID));
		sellingRequestRepository.delete(sellingRequest);
	    return ResponseEntity.ok().build();
	}
	
}
