package com.demo.service;

import java.util.List;

import com.demo.dto.User;
import com.demo.model.UserModel;

public interface UserService {
	
	List<User> getUserList();
	
	User saveUser(UserModel userModel);
	
	UserModel getUser(Integer id);
	
	Boolean deleteUser(String id);

}
