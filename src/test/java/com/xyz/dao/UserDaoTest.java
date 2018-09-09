package com.xyz.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyz.Application;
import com.xyz.model.User;
import com.xyz.util.UserException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = Application.class )

public class UserDaoTest {
	
	
    @Autowired
    @InjectMocks
    @Qualifier("userDao")
	UserDaoImpl userDao;
	
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
	@Test
	public void doCreateUser() throws UserException{
		 User exptUser=null;
		 User user=new User();
		 user.setName("XYZ");
		 user.setEmail("abc@gmail.com");
		 user.setAddress("Blore");
		 exptUser=userDao.create(user);
	     assertThat(user.getName()).isEqualTo(exptUser.getName());
	}
	
	

}
