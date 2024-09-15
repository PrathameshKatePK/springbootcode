package com.hefshine.ecom.serviceImpl;


import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hefshine.ecom.entity.CartItem;
import com.hefshine.ecom.repository.CartRepository;
import com.hefshine.ecom.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
    public CartItem addCartItem(CartItem cartItem) {
        // Save the cart item to the database
        return cartRepository.save(cartItem);
    }

    @Override
    public List getCartItems() {
        // Retrieve all cart items from the database
        return (List) cartRepository.findAll();
    }

    @Override
    public CartItem updateCartItem(Long id, CartItem cartItem) {
        // Find the existing cart item by ID
        Optional<CartItem> existingCartItemOptional = cartRepository.findById(id);
        
        if (existingCartItemOptional.isPresent()) {
            CartItem existingCartItem = existingCartItemOptional.get();
            // Update fields of the cart item
            existingCartItem.setQuantity(cartItem.getQuantity());
            existingCartItem.setPrice(cartItem.getPrice());
            // Save the updated cart item
            return cartRepository.save(existingCartItem);
        }
        
        // If cart item is not found, return null or handle accordingly
        return null;
    }

    @Override
    public void removeCartItem(Long id) {
        // Remove the cart item by ID
    	cartRepository.deleteById(id);
    }

	
}