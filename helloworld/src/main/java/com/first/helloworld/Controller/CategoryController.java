package com.first.helloworld.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
//
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.first.helloworld.Entitys.Category;
import com.first.helloworld.Entitys.CategoryRepo;
import com.first.helloworld.Entitys.User;

@Controller
@RequestMapping(path = "/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
		
	@PostMapping(path = "/add")
	public @ResponseBody String addProduct(@RequestBody Category a) {
		Category category = new Category();

		category.setId(a.getId());
		category.setName(a.getName());
		category.setDescription(a.getDescription());
		
		category.settActive(a.getActive());
		categoryRepo.save(category);
		return "category added successfully";
	}

	@GetMapping(path = "/list")
	public @ResponseBody List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	@GetMapping(path = "/list/{categoryId}")
	public @ResponseBody Category getCategoryById(@PathVariable int categoryId) {
		return categoryRepo.findById(Long.valueOf(categoryId)).orElse(null);
	}
	
	@PutMapping(path ="/update/{categoryId}")
	public @ResponseBody String updateCategory(@PathVariable Long categoryId,@RequestBody Category a) {
		Category category = categoryRepo.findById(Long.valueOf(categoryId)).orElse(null);
		category.setName(a.getName());
		category.setDescription(a.getDescription());
		
		category.settActive(a.getActive());
		categoryRepo.save(category);
		return "category updated successfully";
	}
	
	@DeleteMapping(path = "/delete/{categoryId}")
	public @ResponseBody String deleteCategory(@PathVariable Long categoryId) {
		Category category = categoryRepo.findById(Long.valueOf(categoryId)).orElse(null);
		if (category != null) {
			categoryRepo.delete(category);
			return "delete successfully";
		} else
			return "delete unsuccessfully";
	}
	
	
}