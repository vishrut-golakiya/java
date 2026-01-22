package com.first.helloworld.Entitys;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	Product findByname(String name);
	List<Product> findBynameContainingIgnoreCase(String name);
	List<Product> findByCategoryId(Long id);
}