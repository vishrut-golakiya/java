package com.first.helloworld.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.first.helloworld.Entitys.Category;
import com.first.helloworld.Entitys.CategoryRepo;

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

	@GetMapping(path = "/list/{c}")
	public @ResponseBody Category getProductById(@PathVariable int productId) {
		return categoryRepo.findById(Long.valueOf(productId)).orElse(null);
	}
}
