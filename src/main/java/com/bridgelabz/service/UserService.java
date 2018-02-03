package com.bridgelabz.service;

import java.util.Map;

import com.bridgelabz.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
	
	String saveUser(String key, User user) throws JsonProcessingException;
	long deleteUser(String key);
	Map<String, String> getUser(String key);
	String getSingleUser(String key, String objectKey, String fieldName);
}
