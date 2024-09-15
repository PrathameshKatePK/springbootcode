package com.hefshine.ecom.service;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.hefshine.ecom.entity.CartItem;
@Service
public interface CartService {

	CartItem addCartItem(CartItem cartItem);

	List getCartItems();

	CartItem updateCartItem(Long id, CartItem cartItem);

	void removeCartItem(Long id);

}
