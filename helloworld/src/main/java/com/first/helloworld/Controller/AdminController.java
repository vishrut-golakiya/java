package com.first.helloworld.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.first.helloworld.Entitys.AdminRepo;
import com.first.helloworld.Entitys.Category;
import com.first.helloworld.Entitys.CategoryRepo;
import com.first.helloworld.Entitys.Product;
import com.first.helloworld.Entitys.ProductRepo;
import com.first.helloworld.Entitys.User;
import com.first.helloworld.Entitys.Admin;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@PostMapping(path = "/register")
//	public @ResponseBody String addAdmin(@RequestParam String user_name, @RequestParam String password) {
//
//		Admin admin = new Admin();
//
//		admin.setUsername(user_name);
//		admin.setPassword(password);
//		adminRepo.save(admin);
//		return "Details got Saved";
//
//	}
	public @ResponseBody String addAdmin(@RequestBody Admin a) {

		Admin admin = new Admin();

		admin.setUsername(a.getUsername());
		admin.setPassword(a.getPassword());
		adminRepo.save(admin);
		return "Details got Saved";

	}

	@GetMapping(path = "/getall")
	public @ResponseBody List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

	@GetMapping(path = "/get/{userId}")
	public @ResponseBody Admin getAdminDetails(@PathVariable int userId) {
		return adminRepo.findById(Long.valueOf(userId)).orElse(null);

	}

	@PostMapping(path = "/login")
//     public @ResponseBody String login_admin (@RequestParam String userName, @RequestParam String password) {
//    	 Admin local =adminRepo.findByUsername(userName);
//    	 if(local!=null) {
//    		 if(local.getPassword().equals(password)) {
//    			 return "login successful";
//    		 }
//    		 else {
//    			 return "invalid password";
//    		 }
//    	 }
//    	
//    	 return "invalid username";
//     }
	public @ResponseBody String login_admin(@RequestBody Admin admin) {
		Admin local = adminRepo.findByUsername(admin.getUsername());

		if (local != null) {
			if (local.getPassword().equals(admin.getPassword())) {
				return "login successful";
			} else {
				return "invalid password";
			}
		}

		return "invalid username";
	}

	@PostMapping(path = "/product/add")
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

	@GetMapping(path = "/product/getall")
	public @ResponseBody List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@GetMapping(path = "/product/get/{productId}")
	public @ResponseBody Product getProductById(@PathVariable int productId) {
		return productRepo.findById(Long.valueOf(productId)).orElse(null);
	}
	
	
	@DeleteMapping(path = "/delete")
	public @ResponseBody String DeleteByUserId(@RequestParam int productId) {
		Product local = productRepo.findById(Long.valueOf(productId)).orElse(null);
		if (local != null) {
			productRepo.delete(local);
			return "delete successfully";
		} else
			return "delete unsuccessfully";
	}
	
	
	@GetMapping(path = "product/search")
	public @ResponseBody List<Product> searchByProductname(@RequestParam String name) {
		return productRepo.findBynameContainingIgnoreCase(name);

	}
	
	@GetMapping(path = "product/searchbycategory")
	public @ResponseBody List<Product> searchByCategoryname(@RequestParam String name) {
		Category category = categoryRepo.findByName(name);
		return productRepo.findByCategoryId(Long.valueOf(category.getId()));

	}
	
	
}
