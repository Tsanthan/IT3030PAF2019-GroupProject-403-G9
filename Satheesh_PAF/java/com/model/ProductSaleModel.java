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
@Table(name="product_sale") 
@EntityListeners(AuditingEntityListener.class) 
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class ProductSaleModel {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int saleID; 
	private String fkProductCode;  
	private int fkStockID;
	private double quantity;
	private double amount;
	private double discount;
	private double netAmount;
	private int fkInvoiceNo;
	private String status;
	private String dateTime;
	private int fkUserID;
	public synchronized int getSaleID() {
		return saleID;
	}
	public synchronized void setSaleID(int saleID) {
		this.saleID = saleID;
	}
	public synchronized String getFkProductCode() {
		return fkProductCode;
	}
	public synchronized void setFkProductCode(String fkProductCode) {
		this.fkProductCode = fkProductCode;
	}
	public synchronized int getFkStockID() {
		return fkStockID;
	}
	public synchronized void setFkStockID(int fkStockID) {
		this.fkStockID = fkStockID;
	}
	public synchronized double getQuantity() {
		return quantity;
	}
	public synchronized void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public synchronized double getAmount() {
		return amount;
	}
	public synchronized void setAmount(double amount) {
		this.amount = amount;
	}
	public synchronized double getDiscount() {
		return discount;
	}
	public synchronized void setDiscount(double discount) {
		this.discount = discount;
	}
	public synchronized double getNetAmount() {
		return netAmount;
	}
	public synchronized void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
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
