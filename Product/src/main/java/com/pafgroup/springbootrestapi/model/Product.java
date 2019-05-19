package com.pafgroup.springbootrestapi.model;

import java.io.Serializable; 
import java.util.Date; 

import javax.persistence.Entity; 
import javax.persistence.EntityListeners; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Table; 
import javax.persistence.Temporal; 
import javax.persistence.TemporalType; 
 
import org.hibernate.validator.constraints.NotBlank; 
import org.springframework.data.annotation.LastModifiedDate; 
import org.springframework.data.jpa.domain.support.AuditingEntityListener; 
 
@Entity 
@Table(name="product_registration") 
@EntityListeners(AuditingEntityListener.class) 
public class Product {
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private Long product_code; 
	private String product_name;  
	private Long pro_reg_fk_type_id;  
	private String description;
	private boolean status;
	private Date date_time;
	private Long pro_reg_fk_user_id;
	
	public Long getProduct_code() {
		return product_code;
	}
	public void setProduct_code(Long product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Long getPro_reg_fk_type_id() {
		return pro_reg_fk_type_id;
	}
	public void setPro_reg_fk_type_id(Long pro_reg_fk_type_id) {
		this.pro_reg_fk_type_id = pro_reg_fk_type_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public Long getPro_reg_fk_user_id() {
		return pro_reg_fk_user_id;
	}
	public void setPro_reg_fk_user_id(Long pro_reg_fk_user_id) {
		this.pro_reg_fk_user_id = pro_reg_fk_user_id;
	}

}
