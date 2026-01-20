package com.first.helloworld.Entitys;

import jakarta.persistence.Entity;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@Column(nullable = true)
	private int category_id;

	private String description;

	private double price;
	

	private int quantity;
	
	private boolean active;

	public Product() {
	}

	public Product(String name, String description, double price, int quantity, boolean active) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.active = active;
		
				}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public int getCategoryId() {
		return category_id;
	}

	public void setCategoryId(int id) {
		this.category_id = id;
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
