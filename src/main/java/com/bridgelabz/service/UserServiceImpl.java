package com.bridgelabz.service;

import java.util.HashMap;
import java.util.Map;

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
		hashMap.put(String.valueOf(user.getId()), mapper.writeValueAsString(user));
		return userDao.saveUser(key, hashMap);
	}

	public long deleteUser(String key) {
		return userDao.deleteUser(key);
	}

	public Map<String, String> getUser(String key) {
		return userDao.getUser(key);
	}

	public String getSingleUser(String key, String objectKey, String fieldName) {
		return userDao.getSingleUser(key, objectKey, fieldName);
	}

}
