package com.first.helloworld.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.helloworld.Entitys.Category;
import com.first.helloworld.Entitys.Review;
import com.first.helloworld.repo.ReviewRepo;

@Controller
@RequestMapping(path = "/admin")
public class ReviewController {

	@Autowired
	ReviewRepo reviewRepo;

	@PostMapping(path = "/review")
	public @ResponseBody String addProduct(@RequestBody Review a) {
		Review review = new Review();

		review.setId(a.getId());
		review.setComment(a.getcomment());
		review.setProductId(a.getProductId());
		review.setRating(a.getRating());
		review.setUserId(a.getUserId());
		review.setCreatedAt(a.getCreatedAt());
		reviewRepo.save(review);
		return "review added successfully";
	}
	
	@GetMapping(path = "/review")
	public @ResponseBody List<Review> ReviewAll() {
		return reviewRepo.findAll();
	}
	
	@GetMapping(path="/review/{rating}")
	public @ResponseBody List<Review> GetReviewByRating(@PathVariable int rating) {
		return reviewRepo.findByRating(rating);
	}
	
	
}
