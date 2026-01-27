package com.first.helloworld.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long reviewId;
	private String comment;
	private Long userId;
	private Long productId;
	private int rating;
	private String createdAt;
	
	public Review(String comment, String createdAt, int rating,Long userId, Long productId) {
		this.comment=comment;
		this.userId= userId;
		this.productId=productId;
		this.createdAt=createdAt;
		this.rating=rating;
		
	}
	
	public Review() {
	}

	public Long getId() {
		return reviewId;	
	}

	public void setId(Long id) {
		this.reviewId = id;
	}
	
	public Long getUserId() {
		return userId;	
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;	
	}

	public void setProductId(Long productId) {
		this.productId =productId;
	}
	public int getRating() {
		return rating;	
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getcomment() {
		return comment;	
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreatedAt() {
		return createdAt;	
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}

