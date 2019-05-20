package com.model;

import java.io.Serializable; 
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
@Table(name="invoice") 
@EntityListeners(AuditingEntityListener.class) 
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class InvoiceModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceNo; 
	private int fkSaleID;
	@NotBlank
	private String fkBuyerCode;  
	private String fkSellerCode;
	private double grossAmount;
	private double totDiscount;
	private double netAmount;	
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
	public synchronized int getFkSaleID() {
		return fkSaleID;
	}
	public synchronized void setFkSaleID(int fkSaleID) {
		this.fkSaleID = fkSaleID;
	}
	public synchronized String getFkBuyerCode() {
		return fkBuyerCode;
	}
	public synchronized void setFkBuyerCode(String fkBuyerCode) {
		this.fkBuyerCode = fkBuyerCode;
	}
	public synchronized String getFkSellerCode() {
		return fkSellerCode;
	}
	public synchronized void setFkSellerCode(String fkSellerCode) {
		this.fkSellerCode = fkSellerCode;
	}
	public synchronized double getGrossAmount() {
		return grossAmount;
	}
	public synchronized void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}
	public synchronized double getTotDiscount() {
		return totDiscount;
	}
	public synchronized void setTotDiscount(double totDiscount) {
		this.totDiscount = totDiscount;
	}
	public synchronized double getNetAmount() {
		return netAmount;
	}
	public synchronized void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
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
