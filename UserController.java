package com.hefshine.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.ecom.entity.User;
import com.hefshine.ecom.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User registeredUser = userService.registerUser(user);
		return ResponseEntity.ok(registeredUser); // Successful registration response
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
	    User foundUser = userService.loginUser(user.getEmail(), user.getPassword());
	    if (foundUser != null) {
	        return ResponseEntity.ok(foundUser); // Successful login
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	    }
	}

}
