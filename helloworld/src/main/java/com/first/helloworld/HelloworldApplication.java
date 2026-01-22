package com.first.helloworld;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
//		try {
//			Class.forName("org.postgresql.Driver");
//			System.out.println("friver loaded");
//			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecom","postgres","123");
//			System.out.println("connection done");
//			
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
		SpringApplication.run(HelloworldApplication.class, args);
	}

}
