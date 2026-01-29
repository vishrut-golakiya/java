

package com.first.helloworld.Entitys;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CouponsRepo extends JpaRepository<Coupons, Long>{
	Coupons findByName(String name);
	List<Category> findBynameContainingIgnoreCase(String name);
}