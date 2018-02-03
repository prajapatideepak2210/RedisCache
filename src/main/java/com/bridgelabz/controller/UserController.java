package com.bridgelabz.controller;

import java.util.Map;

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

	@RequestMapping(value = "/saveUser/{key}", method = RequestMethod.POST)
	public ResponseEntity<Response> saveUser(@RequestBody User user, @PathVariable String key) {
		Response response = new Response();
		String returnResponse = null;
		try {
			returnResponse = userService.saveUser(key, user);
		} catch (Exception e) {
			response.setMessage("wrong input.");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

		if (returnResponse.equals("OK")) {
			response.setMessage("User Successfully Added.");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}
		response.setMessage("User is not added, something went wrong.");
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/deleteUser/{key}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteUser(@PathVariable String key) {
		Response response = new Response();
		long returnResponse = 0;
		try {
			returnResponse = userService.deleteUser(key);
		} catch (Exception e) {
			response.setMessage("some internal problem occured.");
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (returnResponse == 1) {
			response.setMessage("user successfully deleted.");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}
		response.setMessage("user is not deleted.");
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getUser/{key}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> getUser(@PathVariable String key) {
		Map<String, String> user = null;
		try {
			user = userService.getUser(key);
		} catch (Exception e) {
			return new ResponseEntity<Map<String, String>>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!user.isEmpty()) {
			return new ResponseEntity<Map<String, String>>(user, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Map<String, String>>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/getSingleUser/{key}/{objectKey}/{fieldName}", method = RequestMethod.GET)
	public ResponseEntity<String> getUser(@PathVariable String key, String objectKey, String fieldName) {
		String user = null;
		try {
			user = userService.getSingleUser(key, objectKey, fieldName);
		} catch (Exception e) {
			System.out.println("controller");
			return new ResponseEntity<String>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!user.isEmpty()) {
			return new ResponseEntity<String>(user, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

}
