package com.bridgelabz.dao;

import java.util.HashMap;

import com.bridgelabz.model.User;

public interface UserDao {
	String saveUser(String key, User user, HashMap<String, String> hashMap);
	void deleteUser(User user);
}
