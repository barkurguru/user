package com.xyz.service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.controller.UserController;
import com.xyz.dao.UserDao;
import com.xyz.model.User;
import com.xyz.util.UserException;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	private static final Logger logger = LogManager.getLogger(UserController.class.getName());
	
	public User createUser(User user) throws UserException{
		User usrSer=null;
		logger.info("inside userservice impl, with user >> "+user.getName() );
		try{
			usrSer=userDao.create(user);
		}catch(Exception e){
			String 	excpnMsg=null;
			if(e instanceof SQLException || e instanceof IOException || e instanceof UnknownHostException ){
				if(e instanceof SQLException){
			    	   if(e.getCause() instanceof IOException || e.getCause() instanceof UnknownHostException){
			    		   excpnMsg="IO / UnknownHost Exception in User service impl  for [User name=\'"+ user.getName()  +"\']  and [User Email=\'"+ user.getEmail()  +"\'], while acquiring connection >> "+e.getMessage();
			    	   }
			    	   else{
			    		   excpnMsg="SQL Exception in User service impl for[User name=\'"+ user.getName()  +"\']  and [User Email=\'"+ user.getEmail()  +"\'], while executing query >> "+e.getMessage();
			    	   }
				}	   
				logger.error(excpnMsg);
			}
		}
		return usrSer;
	}

}
