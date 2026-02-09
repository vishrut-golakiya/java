package com.first.helloworld.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.helloworld.Entitys.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	Product findByname(String name);
	List<Product> findBynameContainingIgnoreCase(String name);
	List<Product> findByCategoryId(Long id);
	List<Product> findByActive(boolean isActive);
}