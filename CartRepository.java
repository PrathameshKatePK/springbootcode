package com.hefshine.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.ecom.entity.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {

}
