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

import com.first.helloworld.Entitys.User;
import com.first.helloworld.repo.OrderRepo;
import com.first.helloworld.Entitys.Admin;
import com.first.helloworld.Entitys.Order;

@Controller
@RequestMapping(path = "/admin")
public class OrderController {

	@Autowired
	private OrderRepo orderRepo;

	@PostMapping(path = "/orders")
	public @ResponseBody String adOrder(@RequestBody Order a) {

		Order order = new Order();

		order.setCreatedAt(a.getCreatedAt());
		order.setUserId(a.getUserId());
		order.setOrderStatus(a.isOrderStatus());
		order.setPaymentStatus(a.isPaymentStatus());
		order.setTotalAmount(a.getTotalAmount());
		orderRepo.save(order);
		return "Details got Saved";

	}

	@GetMapping(path = "/orders")
	public @ResponseBody List<Order> getAllOrder() {
		return orderRepo.findAll();
	}

	@PutMapping(path = "/orders/status/{orderId}")
	public @ResponseBody String updateOrderStatus(@PathVariable int orderId, @RequestParam String status) {
		Order local = orderRepo.findById(Long.valueOf(orderId)).orElse(null);
		if (local != null) {

			local.setOrderStatus(status);
			orderRepo.save(local);
			return "update successfully";
		} else
			return "update unsuccessfully";

	}

	@GetMapping(path = "/orders/pending")
	public @ResponseBody List<Order> getPendingOrders() {
		return orderRepo.findByOrderStatus("pending");
	}

	@GetMapping(path = "/orders/shipped")
	public @ResponseBody List<Order> getShippedOrders() {
		return orderRepo.findByOrderStatus("shipped");
	}

	@GetMapping(path = "/orders/delivered")
	public @ResponseBody List<Order> getDeliveredOrders() {
		return orderRepo.findByOrderStatus("delivered");
	}
	
	@DeleteMapping(path="/orders/cancle/{orderId}")
	public @ResponseBody String cancleOrder(@PathVariable Long orderId) {
		
		Order order= orderRepo.findById(Long.valueOf(orderId)).orElse(null);
		orderRepo.delete(order);
		return "";
	}
}
