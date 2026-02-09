
package com.first.helloworld.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.helloworld.Entitys.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{
	Category findByName(String name);
	List<Category> findBynameContainingIgnoreCase(String name);
}

