package com.demo.dao;

import java.util.List;

import com.demo.model.User;

public interface UserDao {
	
	List<User> getUserList();
	
	User getUser(User user);
	
	Boolean saveUser(User user);
	
	Boolean deleteUser(User user);
	

}
