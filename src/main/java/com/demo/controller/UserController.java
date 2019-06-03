package com.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public HashMap<String, Object> getUserList() {
		HashMap<String, Object> responseObject = new HashMap<String, Object>();
		List<User> userList = userService.getUserList();
		responseObject.put("object", userList);
		responseObject.put("message", "User list send successfully.");
		responseObject.put("status", 200);
		return responseObject;
	}

}
