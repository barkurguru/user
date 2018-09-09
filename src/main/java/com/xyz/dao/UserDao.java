/**
 * 
 */
package com.xyz.dao;

import java.util.List;

import com.xyz.model.User;
import com.xyz.util.UserException;

/**
 * @author only2dhir
 *
 */
//@Repository("userDao")
public interface UserDao {

	public User create(final User user) throws UserException;

/*	public List<User> findAll();

	public User findUserById(int id);*/

}
