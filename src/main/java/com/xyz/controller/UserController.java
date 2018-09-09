package com.xyz.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.model.User;
import com.xyz.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = LogManager.getLogger(UserController.class.getName());
	
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@RequestBody User user) throws UserException {
		User userCre=null;
		try{
			logger.info("inside usercontroller for user >> "+user.getName() );
			userCre=userService.createUser(user);
		}catch(Exception e){
			System.out.println("controller exception");
			logger.error("exception occured in user controller>> "+e.getMessage());
			//e.printStackTrace();
		}
		return ResponseEntity.ok(userCre);
	}

}
