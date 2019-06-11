package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.User;
import com.demo.model.ResponseModel;
import com.demo.model.UserModel;
import com.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/users")
	public ResponseModel getUserList() {
		ResponseModel responseObject = new ResponseModel();
		List<User> userList = userService.getUserList();
		responseObject.setObject(userList);
		responseObject.setMessage("User list send successfully.");
		responseObject.setStatus(200);
		return responseObject;
	}
	
	@PostMapping("/users")
	public ResponseModel saveUser(@RequestBody UserModel userModel) {
		ResponseModel responseObject = new ResponseModel();
		User user = userService.saveUser(userModel);
		responseObject.setObject(user);
		responseObject.setMessage("User record saved successfully.");
		responseObject.setStatus(200);
		return responseObject;
	}
	
	@GetMapping("/users/{userId}")
	public ResponseModel deleteUser(HttpServletRequest request, @PathVariable("userId") String userId) {
		logger.info(request.toString());
		logger.info(userId);
		ResponseModel responseObject = new ResponseModel();
		if(userService.deleteUser(userId)) {			
			responseObject.setObject(true);
			responseObject.setMessage("User record deleted successfully.");
			responseObject.setStatus(200);
		} else {
			responseObject.setObject(false);
			responseObject.setMessage("Something went wrong, please try again.");
			responseObject.setStatus(500);
		}
		return responseObject;
	}
	
	

}
