

package com.first.helloworld.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.helloworld.Entitys.Coupons;


@Repository
public interface CouponsRepo extends JpaRepository<Coupons, Long>{
//	Coupons findByName(String name);
//	List<Category> findBynameContainingIgnoreCase(String name);
}