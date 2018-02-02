package com.bridgelabz.service;

import com.bridgelabz.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
	
	String saveUser(String key, User user) throws JsonProcessingException;
	void deleteUser(User user);
}
