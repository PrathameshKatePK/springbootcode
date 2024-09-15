package com.hefshine.ecom.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hefshine.ecom.entity.User;
import com.hefshine.ecom.repository.UserRepository;
import com.hefshine.ecom.service.UserService;

@Service
public  class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		User use = userRepository.save(user);
		return use;
		
	}
	@Override
    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
	
	
	

}
