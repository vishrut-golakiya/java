package com.first.helloworld.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.helloworld.Entitys.OrderRepo;
import com.first.helloworld.Entitys.User;
import com.first.helloworld.Entitys.Order;

@Controller
@RequestMapping(path = "/admin/orders")
public class OrderController {
	
	@Autowired
	private OrderRepo orderRepo;   
	
	@GetMapping(path = "/getall")
	public @ResponseBody List<Order> getAllOrder() {
		return orderRepo.findAll();
	}
	@PutMapping(path = "/updatestatus/{orderId}")
	public @ResponseBody String updateOrderStatus(@PathVariable int orderId, @RequestBody Order order) {
		Order local = orderRepo.findById(Long.valueOf(orderId)).orElse(null);
		if (local != null) {

			local.setOrderStatus(order.isOrderStatus());
			orderRepo.save(local);
			return "update successfully";
		} else
			return "update unsuccessfully";

	}
	@GetMapping(path = "/pending")
	public @ResponseBody List<Order> getPendingOrders() {
		return orderRepo.findByOrderStatus("pending");	
	}
	
	@GetMapping(path = "/shipped")
	public @ResponseBody List<Order> getShippedOrders() {
		return orderRepo.findByOrderStatus("shipped");	
	}
	
	@GetMapping(path = "/delivered")
	public @ResponseBody List<Order> getDeliveredOrders() {
		return orderRepo.findByOrderStatus("delivered");	
	}
}
