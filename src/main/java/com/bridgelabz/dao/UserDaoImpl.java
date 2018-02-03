package com.bridgelabz.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

@Repository
public class UserDaoImpl implements UserDao{

	public String saveUser(String key, HashMap<String, String> hashMap) {
		Jedis jedis = new Jedis();
		String result = jedis.hmset(key, hashMap);
		System.out.println(jedis.hgetAll(key));
		jedis.close();
		return result;
	}

	public long deleteUser(String key) {
		Jedis jedis = new Jedis();
		Long result = jedis.del(key);
		System.out.println("delete result : "+result);
		jedis.close();
		return result;
	}

	public Map<String, String> getUser(String key) {
		Jedis jedis = new Jedis();
		Map<String, String> user = jedis.hgetAll(key);
		System.out.println(jedis.hgetAll(key).get(String.valueOf(1)));
		jedis.close();
		return user;
	}
	
	public String getSingleUser(String key, String objectKey, String fieldName){
		Jedis jedis = new Jedis();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("field name : "+fieldName);
		User user = null;
		try {
			user = mapper.readValue(jedis.hgetAll(key).get(String.valueOf(1)), User.class);
		} catch (IOException e) {
			System.out.println("kasdghasdlkjgbadf;kjgldkagbasliuf");
			e.printStackTrace();
		}
		jedis.close();
		if(fieldName.equals("name")){
			System.out.println(user.getName());
			return user.getName();}
		else if(fieldName.equals("contact")){
			System.out.println(user.getContact());
			return user.getContact();
		}
		else if(fieldName.equals(null)){
			System.out.println("kljasdvhfksldajbgadfskjngadfngnjlndf;lfgn");
			return "mt kr try koi mtlb nahi h";
		}
		else{
			return null;
		}
	}

}
