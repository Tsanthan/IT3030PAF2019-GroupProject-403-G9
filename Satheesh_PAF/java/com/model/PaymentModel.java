package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name="payment") 
@EntityListeners(AuditingEntityListener.class) 
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class PaymentModel {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceNo; 
	private String paymentMethod;
	@NotBlank
	private String paymentDescription;
	private String status;
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private String dateTime;
	private int fkUserID;
	public synchronized int getInvoiceNo() {
		return invoiceNo;
	}
	public synchronized void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public synchronized String getPaymentMethod() {
		return paymentMethod;
	}
	public synchronized void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public synchronized String getPaymentDescription() {
		return paymentDescription;
	}
	public synchronized void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}
	public synchronized String getStatus() {
		return status;
	}
	public synchronized void setStatus(String status) {
		this.status = status;
	}
	public synchronized String getDateTime() {
		return dateTime;
	}
	public synchronized void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public synchronized int getFkUserID() {
		return fkUserID;
	}
	public synchronized void setFkUserID(int fkUserID) {
		this.fkUserID = fkUserID;
	}
	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}
	
}