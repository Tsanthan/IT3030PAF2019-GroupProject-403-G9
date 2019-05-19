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
@Table(name="product_type_registration") 
@EntityListeners(AuditingEntityListener.class) 
public class ProductType {
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private Long product_type_id; 
	private String product_type;  
	private String main_category;  
	private String sub_category;
	private String description;
	private String status;
	private Date date_time;
	private Long pro_ty_reg_fk_user_id;
	
	public Long getProduct_type_id() {
		return product_type_id;
	}
	public void setProduct_type_id(Long product_type_id) {
		this.product_type_id = product_type_id;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getMain_category() {
		return main_category;
	}
	public void setMain_category(String main_category) {
		this.main_category = main_category;
	}
	public String getSub_category() {
		return sub_category;
	}
	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public Long getPro_ty_reg_fk_user_id() {
		return pro_ty_reg_fk_user_id;
	}
	public void setPro_ty_reg_fk_user_id(Long pro_ty_reg_fk_user_id) {
		this.pro_ty_reg_fk_user_id = pro_ty_reg_fk_user_id;
	}
}
