package com.first.helloworld.Entitys;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Long categoryId;

	private String description;

	private double price;
	

	private int quantity;
	
	private boolean active;

	public Product() {
	}

	public Product(String name, String description, double price, int quantity, boolean active, Long categoryId) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.active = active;
		this.categoryId= categoryId;
				}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long id) {
		this.categoryId = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
