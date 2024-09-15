package com.hefshine.ecom.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.ecom.entity.CartItem;
import com.hefshine.ecom.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200/")
public class CartController {
	 @Autowired
	    private CartService cartService;

	    @PostMapping("/add")
	    public CartItem addToCart(@RequestBody CartItem cartItem) {
	        return cartService.addCartItem(cartItem);
	    }

	    @GetMapping
	    public List getCartItems() {
	        return cartService.getCartItems();
	    }

	    @PutMapping("/update/{id}")
	    public CartItem updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItem) {
	        return cartService.updateCartItem(id, cartItem);
	    }

	    @DeleteMapping("/remove/{id}")
	    public void removeCartItem(@PathVariable Long id) {
	        cartService.removeCartItem(id);
	    }

}
