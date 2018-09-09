package com.xyz.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.xyz.model.User;
import com.xyz.util.UserException;

public class UserServiceTest {
	
	
    @Mock
	UserServiceImpl userService;
	
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    @Test
    public void create() throws UserException{
		 User exptUser=null;
		 User user=new User();
		 user.setName("XYZ");
		 user.setEmail("abc@gmail.com");
		 user.setAddress("Blore");
    	try{
    		exptUser=userService.createUser(user);
    		assertThat(user.getName()).isEqualTo(exptUser.getName());
    	}catch(Exception e){
    		System.out.println("exception in service test >> "+e.getMessage());
    	}
    }
 
}
