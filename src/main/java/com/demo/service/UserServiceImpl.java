package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.User;
import com.demo.model.UserModel;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	Mapper mapper = new DozerBeanMapper();

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	

	@Override
	public List<User> getUserList() {
		ArrayList<User> userList = new ArrayList<User>();
		try {
			userList = (ArrayList<User>) userRepository.findAll();
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return userList;
	}

	@Override
	public UserModel getUser(Integer id) {
		UserModel user = new UserModel();
		try {
			user = mapper.map(userRepository.findByIdAndName(id, "suraj"), UserModel.class);			
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return user;
	}

	@Override
	public User saveUser(UserModel userModel) {
		User user = mapper.map(userModel, User.class);
		try {
			user = userRepository.save(user);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return user;
	}

	@Override
	public Boolean deleteUser(String id) {
		try {
			Optional<User> user = userRepository.findById(Integer.parseInt(id));
			userRepository.delete(user.get());
			return true;
		} 
		catch (Exception e) {
			logger.info(e.toString());
			return false;
		}
	}

}
