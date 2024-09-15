package com.hefshine.ecom.service;

import com.hefshine.ecom.entity.User;

public interface UserService {

	User registerUser(User user);

	User loginUser(String email, String password);

}
