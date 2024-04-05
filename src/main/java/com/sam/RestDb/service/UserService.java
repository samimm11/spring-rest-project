package com.sam.RestDb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.RestDb.bean.User;
import com.sam.RestDb.dao.UserRepository;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public List<User> getUsersByName(String name) {
		logger.info("Getting User by name : " + name);
		return userRepository.findByName(name);

	}

	public List<User> getUsers() {
		logger.info("Getting all users ");
		return userRepository.findAll();
	}

	public List<User> findByNameContainingNativeQuery(String name) {
		return userRepository.findByNameContainingNativeQuery(name);
	}
}
