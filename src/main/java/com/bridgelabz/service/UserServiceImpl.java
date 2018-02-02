package com.bridgelabz.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public String saveUser(String key, User user) throws JsonProcessingException {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		hashMap.put("1", mapper.writeValueAsString(user));
		
		return userDao.saveUser(key, user, hashMap);
	}

	public void deleteUser(User user) {
		
	}

}
