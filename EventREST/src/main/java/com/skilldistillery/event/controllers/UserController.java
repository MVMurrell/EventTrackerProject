package com.skilldistillery.event.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.event.entities.User;
import com.skilldistillery.event.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService uServ;
	
	@GetMapping("users")
	public List<User> listUsers() {
		return uServ.index();
	}
}
