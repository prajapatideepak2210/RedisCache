package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.model.Response;
import com.bridgelabz.model.User;
import com.bridgelabz.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/saveUser/{key}", method=RequestMethod.POST)
	public ResponseEntity<Response> saveUser(@RequestBody User user, @PathVariable String key){
		Response response = new Response();
		String returnResponse = null;
		try {
			returnResponse = userService.saveUser(key, user);
		} catch (Exception e) {
			response.setMessage("wrong input.");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(returnResponse.equals("OK")){
			System.out.println("deepak ka Redis : "+returnResponse);
			response.setMessage("User Successfully Added.");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		response.setMessage("User is not added, something went wrong.");
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
