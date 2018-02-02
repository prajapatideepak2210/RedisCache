package com.bridgelabz.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;

import redis.clients.jedis.Jedis;

@Repository
public class UserDaoImpl implements UserDao{

	public String saveUser(String key, User user, HashMap<String, String> hashMap) {
		Jedis jedis = new Jedis();
		String check = jedis.hmset(key, hashMap);
		System.out.println(jedis.hgetAll(key));
		jedis.close();
		return check;
	}

	public void deleteUser(User user) {
		
	}
	
	

}
