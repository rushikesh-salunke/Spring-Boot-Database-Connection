package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDao;
import com.demo.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}
	
	@Transactional
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public Boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
