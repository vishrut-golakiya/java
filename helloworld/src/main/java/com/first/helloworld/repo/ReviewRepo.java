
package com.first.helloworld.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.helloworld.Entitys.Review;


@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>{
	
	List<Review> findByProductId(Long productId);
	List<Review> findByUserId(Long userId);
	List<Review> findByRating(int rating);
}