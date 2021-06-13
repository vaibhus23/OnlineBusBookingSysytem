package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;
import com.org.service.IUserServiceImpl;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	IUserServiceImpl User_service;

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return User_service.addUser(user);
	}

	@GetMapping("/byUserName/{username}")
	public User getUserByUserName(@PathVariable String username)throws InvalidUsernameException {
		return User_service.getUserDetailsByUserName(username);
	}

	@DeleteMapping("/deletebyUserName/{username}")
	public void deleteByUserName(@PathVariable String username) throws InvalidUsernameException{
		 User_service.deleteUser(username);
	}
	
	@PutMapping("/update/updatePassword/{username}/{newpassword}")
	public ResponseEntity<String> updatePassword(@PathVariable String username, @PathVariable String newpassword)
			throws InvalidUsernameException {
		int count = User_service.updatePassword(username, newpassword);
		if (count == 1) {
			return new ResponseEntity<String>("updated Password", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not Updated", HttpStatus.OK);
		}
	}
}