


package com.first.helloworld.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.helloworld.Entitys.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{
	
	List<Order> findByOrderId(Long id);
	List<Order> findByOrderStatus(String orderStatus);
}
