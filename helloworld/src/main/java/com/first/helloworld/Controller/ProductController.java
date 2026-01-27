package com.first.helloworld.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.helloworld.Entitys.Category;
import com.first.helloworld.Entitys.CategoryRepo;
import com.first.helloworld.Entitys.Product;
import com.first.helloworld.Entitys.ProductRepo;

@Controller
@RequestMapping(path = "/admin")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@PostMapping(path = "/products")
	public @ResponseBody String addProduct(@RequestBody Product a) {
		Product product = new Product();

		product.setId(a.getId());
		product.setName(a.getName());
		product.setDescription(a.getDescription());
		product.setPrice(a.getPrice());
		product.setQuantity(a.getQuantity());
		product.setActive(a.isActive());
		product.setCategoryId(a.getCategoryId());
		productRepo.save(product);
		return "product added successfully";
	}
	
	@GetMapping(path = "/products")
	public @ResponseBody List<Product> getAllProduct() {
		return productRepo.findAll();
	}
	
	@GetMapping(path = "/products/{productId}")
	public @ResponseBody Product getProductById(@PathVariable int productId) {
		return productRepo.findById(Long.valueOf(productId)).orElse(null);
	}
	

	@DeleteMapping(path = "/products/{productId}")
	public @ResponseBody String DeleteByUserId(@PathVariable int productId) {
		Product local = productRepo.findById(Long.valueOf(productId)).orElse(null);
		if (local != null) {
			productRepo.delete(local);
			return "product removed";
		} else
			return "";
	}
	
	@PutMapping(path = "/products/{productId}")
	public @ResponseBody String updateProduct(@PathVariable int productId, @RequestBody Product a) {
		Product product = productRepo.findById(Long.valueOf(productId)).orElse(null);

		product.setId(a.getId());
		product.setName(a.getName());
		product.setDescription(a.getDescription());
		product.setPrice(a.getPrice());
		product.setQuantity(a.getQuantity());
		product.setActive(a.isActive());
		product.setCategoryId(a.getCategoryId());
		productRepo.save(product);
		return "product updated";
	}
	
	@PutMapping(path = "/products/status/{productId}")
	public @ResponseBody String updateStatus(@PathVariable int productId, @RequestParam boolean isActive) {
		Product product = productRepo.findById(Long.valueOf(productId)).orElse(null);
		product.setActive(isActive);
		productRepo.save(product);
		return "product updated";
	}
	
	@GetMapping(path = "/products/search")
	public @ResponseBody List<Product> searchByProductname(@RequestParam String name) {
		return productRepo.findBynameContainingIgnoreCase(name);

	}

	@GetMapping(path = "/products/search/category")
	public @ResponseBody List<Product> searchByCategoryname(@RequestParam String name) {
		Category category = categoryRepo.findByName(name);
		return productRepo.findByCategoryId(Long.valueOf(category.getId()));

	}
	
	@GetMapping(path = "/products/status")
	public @ResponseBody List<Product> searchByActive(@RequestParam boolean isActive) {
		return productRepo.findByActive(isActive);

	}
}
