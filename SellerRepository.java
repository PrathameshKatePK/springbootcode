package com.hefshine.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hefshine.ecom.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

	@Query("SELECT s FROM Seller s WHERE s.username = :username AND s.password = :password")
	Seller findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
