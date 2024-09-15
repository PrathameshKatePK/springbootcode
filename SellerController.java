package com.hefshine.ecom.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.ecom.entity.Seller;
import com.hefshine.ecom.service.SellerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/seller")
public class SellerController {
	@Autowired
	private SellerService sellerService;

	@PostMapping("/signup")
	public Seller registerSeller(@RequestBody Seller seller) {
		return sellerService.registerSeller(seller);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
	    String username = loginData.get("username");
	    String password = loginData.get("password");

	    if (username == null || password == null) {
	        return ResponseEntity.badRequest().body("Username or password is missing");
	    }

	    try {
	        Seller seller = sellerService.authenticateSeller(username, password);
	        if (seller != null) {
	            // Generate a token (for simplicity, we return a dummy token here)
	            String token = "dummy-token"; // You can generate a real token here
	            return ResponseEntity.ok(Map.of("token", token));
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the stack trace for debugging
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error: " + e.getMessage());
	    }
	}
	class LoginRequest {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Getters and Setters

}
}
