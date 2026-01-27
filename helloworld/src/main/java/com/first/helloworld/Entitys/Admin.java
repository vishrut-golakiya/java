package com.first.helloworld.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "register")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long adminId;
	private String adminName;
	private String email;
	private String password;
	
	public Admin(String username, String password, String email) {
		this.adminName=username;
		this.password= password;
		this.email=email;
		
	}
	public Admin() {
	}

	public Long getId() {
		return adminId;	
	}

	public void setId(Long id) {
		this.adminId = id;
	}

	public String getUsername() {
		return adminName;
	}

	public void setUsername(String username) {
		this.adminName = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
