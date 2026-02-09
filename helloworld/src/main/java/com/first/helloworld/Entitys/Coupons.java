package com.first.helloworld.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coupons")
public class Coupons {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long Couponid;
	private String code;
	private String discountType;
	private double discountValue;
	private String expiryDate;
	private boolean isActive;
		

	public Coupons(String code, String discountType, double discountValue,String expiryDate, boolean isActive) {
		this.code=code;
		this.discountType= discountType;
		this.discountValue=discountValue;
		this.expiryDate=expiryDate;
		this.isActive=isActive;
		
	}
	

	public Coupons() {
	}

	public Long getId() {
		return Couponid;	
	}

	public void setId(Long id) {
		this.Couponid = id;
	}
	
	public String getCode() {
		return code;	
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getDiscountType() {
		return discountType;	
	}

	public void setDiscountType(String discountType) {
		this.discountType =discountType;
	}
	public double getRating() {
		return discountValue;	
	}

	public void setRating(double discountValue) {
		this.discountValue = discountValue;
	}
	public String getExpiryDate() {
		return expiryDate;	
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate= expiryDate;
	}
	public boolean getCreatedAt() {
		return isActive;	
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
