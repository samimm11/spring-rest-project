package com.sam.RestDb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.RestDb.bean.User;
import com.sam.RestDb.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{name}")
	public List<User> findByName(@PathVariable String name) {
		return userService.getUsersByName(name);
	}

	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping("/q/{ch}")
	public List<User> findByNameUsingNativeQuery(@PathVariable String ch) {
		return userService.findByNameContainingNativeQuery(ch);
	}

}
