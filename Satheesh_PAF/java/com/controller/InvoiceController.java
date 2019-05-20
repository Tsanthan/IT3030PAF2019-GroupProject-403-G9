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
import com.model.InvoiceModel;
import com.repository.InvoiceRepository;

@RestController
@RequestMapping("/api")
public class InvoiceController {

	@Autowired
    InvoiceRepository invoiceRepository;
	
	// Get All Invoices
	@GetMapping("/invoices")
	public List<InvoiceModel> getAllInvoices() {
	    return invoiceRepository.findAll();
	}
	
	// Create a new Invoice
	@PostMapping("/invoices")
	public InvoiceModel createInvoice(@Valid @RequestBody InvoiceModel invoice) {
	    return invoiceRepository.save(invoice);
	}
	
	// Get a Single Invoice
	@GetMapping("/invoices/{invoice_no}")
	public InvoiceModel getInvoiceById(@PathVariable(value = "invoice_no") Long invoiceID) {
	    return invoiceRepository.findById(invoiceID)
	            .orElseThrow(() -> new ResourceNotFoundExceptionClass("invoice", "invoice_no", invoiceID));
	}
	
	// Update an Invoice
	@PutMapping("/invoices/{invoice_no}")
	public InvoiceModel updateInvoiceModel(@PathVariable(value = "invoice_no") Long invoiceID,
	                                        @Valid @RequestBody InvoiceModel invoiceDetails) {
		InvoiceModel invoice = invoiceRepository.findById(invoiceID)
				.orElseThrow(() -> new ResourceNotFoundExceptionClass("invoice", "invoice_no", invoiceID));
	    
		invoice.setFkSaleID(invoice.getFkSaleID());
		invoice.setFkBuyerCode(invoice.getFkBuyerCode());
		invoice.setFkSellerCode(invoice.getFkSellerCode());
		invoice.setGrossAmount(invoice.getGrossAmount());
		invoice.setTotDiscount(invoice.getTotDiscount());
		invoice.setNetAmount(invoice.getNetAmount());
		invoice.setStatus(invoice.getStatus());
		invoice.setDateTime(invoice.getDateTime());
		invoice.setFkUserID(invoice.getFkUserID());
		InvoiceModel invoModel = invoiceRepository.save(invoice);
		return invoModel;
	}
	
	// Delete an Invoice
	@DeleteMapping("/invoices/{invoice_no}")
	public ResponseEntity<?> deleteInvoice(@PathVariable(value = "invoice_no") Long invoiceID) {
		InvoiceModel invoice = invoiceRepository.findById(invoiceID)
				.orElseThrow(() -> new ResourceNotFoundExceptionClass("invoice", "invoice_no", invoiceID));
	    invoiceRepository.delete(invoice);
	    return ResponseEntity.ok().build();
	}
	
}
