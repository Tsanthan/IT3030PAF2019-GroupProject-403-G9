package com.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name="selling_request") 
@EntityListeners(AuditingEntityListener.class) 
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class SellingRequestModel {

	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int requestID; 
	private int fkInvoiceNo;
	private String status;
	private String dateTime;
	private int fkUserID;
	public synchronized int getRequestID() {
		return requestID;
	}
	public synchronized void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public synchronized int getFkInvoiceNo() {
		return fkInvoiceNo;
	}
	public synchronized void setFkInvoiceNo(int fkInvoiceNo) {
		this.fkInvoiceNo = fkInvoiceNo;
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

}
