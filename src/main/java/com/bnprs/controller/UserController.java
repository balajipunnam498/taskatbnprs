package com.bnprs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnprs.model.User;
import com.bnprs.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
		@Autowired
		private UserServiceImpl userservice;
		
	@PostMapping("/saveuser")
	public String registerUser(@RequestBody User user) {
		String saveUser = userservice.saveUser(user);
		return saveUser;
	}
	
	@GetMapping("/getuser/{userid}")
	public User getUser(@PathVariable int userid) {
		User user = userservice.getUser(userid);
		return user;
	}
	@PutMapping("updatemail/{userid}/{email}")
	public String updateEmail(@PathVariable int userid, @PathVariable String email) {
		String updateUser = userservice.updateUser(userid, email);
		return updateUser;
	}
	
	@DeleteMapping("/deleteuser/{userid}")
	public String deleteUser(@PathVariable int userid) {
		String deleteUser = userservice.deleteUser(userid);
		return deleteUser;
	}
	
	@PutMapping("/updateuser/{userid}")
	public String updateUser(@PathVariable int userid,@RequestBody User user) {
		String updateUser = userservice.updateUser(userid, user);
		return updateUser;
	}
}
