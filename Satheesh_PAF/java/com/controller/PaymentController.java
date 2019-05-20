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
import com.model.PaymentModel;
import com.repository.PaymentRepository;

@RestController
@RequestMapping("/api")
public class PaymentController {

	@Autowired
    PaymentRepository paymentRepository;
	
	// Get All Payments
	@GetMapping("/payments")
	public List<PaymentModel> getAllPayments() {
	    return paymentRepository.findAll();
	}
	
	// Make a new Payment
	@PostMapping("/payments")
	public PaymentModel makePayment(@Valid @RequestBody PaymentModel payment) {
	    return paymentRepository.save(payment);
	}
	
	// Get a Single Payment
	@GetMapping("/payments/{invoice_no}")
	public PaymentModel getPaymentById(@PathVariable(value = "invoice_no") Long invoiceID) {
	    return paymentRepository.findById(invoiceID)
	    		.orElseThrow(() -> new ResourceNotFoundExceptionClass("payment", "invoice_no", invoiceID));
	}
	
	// Update a Payment
	@PutMapping("/payments/{invoice_no}")
	public PaymentModel updatePaymentModel(@PathVariable(value = "invoice_no") Long invoiceID,
	                                        @Valid @RequestBody PaymentModel paymentDetails) {
		PaymentModel payment = paymentRepository.findById(invoiceID)
				.orElseThrow(() -> new ResourceNotFoundExceptionClass("payment", "invoice_no", invoiceID));
	    
		payment.setInvoiceNo(payment.getInvoiceNo());
		payment.setPaymentMethod(payment.getPaymentMethod());
		payment.setPaymentDescription(payment.getPaymentDescription());
		payment.setStatus(payment.getStatus());
		payment.setDateTime(payment.getDateTime());
		payment.setFkUserID(payment.getFkUserID());
		PaymentModel paymentModel = paymentRepository.save(payment);
		return paymentModel;
	}
	
	// Delete a payment
	@DeleteMapping("/payments/{invoice_no}")
	public ResponseEntity<?> deletePayment(@PathVariable(value = "invoice_no") Long invoiceID) {
		PaymentModel payment = paymentRepository.findById(invoiceID)
				.orElseThrow(() -> new ResourceNotFoundExceptionClass("payment", "invoice_no", invoiceID));
	    paymentRepository.delete(payment);
	    return ResponseEntity.ok().build();
	}
	
}
