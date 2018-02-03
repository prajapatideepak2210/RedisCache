package com.bridgelabz.dao;

import java.util.HashMap;
import java.util.Map;

public interface UserDao {
	String saveUser(String key, HashMap<String, String> hashMap);
	long deleteUser(String key);
	Map<String, String> getUser(String key);
	String getSingleUser(String key, String objectKey, String fieldName);
}
