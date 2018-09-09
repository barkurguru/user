package com.xyz.service;

import com.xyz.model.User;
import com.xyz.util.UserException;

public interface UserService {
	
	public User createUser(User user) throws UserException ;

}
