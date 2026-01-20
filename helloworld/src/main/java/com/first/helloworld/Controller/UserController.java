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
import com.first.helloworld.Entitys.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@PostMapping(path = "/register")
	public @ResponseBody String addUser(@RequestBody User a) {

		User user = new User();

		user.setUsername(a.getUsername());
		user.setPassword(a.getPassword());
		userRepo.save(user);
		return "Details got Saved";

	}

	@GetMapping(path = "/getall")
	public @ResponseBody List<User> getAllUser() {
		return userRepo.findAll();
	}

	@GetMapping(path = "/get/{userId}")
	public @ResponseBody User getUserDetails(@PathVariable int userId) {
		return userRepo.findById(Long.valueOf(userId)).orElse(null);

	}

	@PostMapping(path = "/login")
	public @ResponseBody String login_admin(@RequestBody User a, HttpSession session) {
		User local = userRepo.findByUsername(a.getUsername());

		if (local != null) {
			session.setAttribute("loggedUser", a.getUsername());
			if (local.getPassword().equals(a.getPassword())) {
				return "login successful";
			} else {
				return "invalid password";
			}
		}

		return "invalid username";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {

		String user = (String) session.getAttribute("loggedUser");

		if (user == null) {
			return "please login first";
		}

		return "welcome " + user;
	}

	@PutMapping(path = "/update/{userId}")
	public @ResponseBody String update_user(@PathVariable int userId, @RequestBody User user) {
		User local = userRepo.findById(Long.valueOf(userId)).orElse(null);
		if (local != null) {

			local.setUsername(user.getUsername());
			userRepo.save(local);
			return "update successfully";
		} else
			return "update unsuccessfully";

	}



	@DeleteMapping(path = "/delete")
	public @ResponseBody String DeleteByUserId(@RequestParam int userId) {
		User local = userRepo.findById(Long.valueOf(userId)).orElse(null);
		if (local != null) {
			userRepo.delete(local);
			return "delete successfully";
		} else
			return "delete unsuccessfully";
	}

}
