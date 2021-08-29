package com.digitalexperts.authService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.service.UserService;

@RestController
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/adduser")
	public User toAddUser(@RequestBody User user) {
		
		 return userService.save(user);
	}
	
	@GetMapping("/users")
	public List<User> listeUsers() {
		
		return userService.findAll();
	}
	@DeleteMapping("/delete/{id}")
	public String supression(@RequestParam Long id){
		return userService.deleteUser(id);
	}

	@PutMapping("/update")
	public User updatUser(@RequestBody User user) {
		
		 return userService.updateUser(user);
	}
}

