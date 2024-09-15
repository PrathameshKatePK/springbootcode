package com.hefshine.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.ecom.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	 User findByEmailAndPassword(String email, String password);

}
