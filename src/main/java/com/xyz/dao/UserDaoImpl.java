/**
 * 
 */
package com.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.xyz.controller.UserController;
import com.xyz.model.User;
import com.xyz.util.UserException;
import com.xyz.util.Utils;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private final String INSERT_SQL = "INSERT INTO USERS (name,address,email) values(?,?,?)";
	private final String FETCH_SQL = "select record_id, name, address, email from USERS";
	private final String FETCH_SQL_BY_ID = "select * from USERS where record_id = ?";
	
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());
	
	

	
	public User create( User user) throws UserException {
		Connection con=null;PreparedStatement ps;
		System.out.println("inside UserDaoImpl");
		KeyHolder holder = new GeneratedKeyHolder();
		ResultSet rs;int i=0;
		try{
			 con=Utils.getConnection();
			 ps = con.prepareStatement(INSERT_SQL,  Statement.RETURN_GENERATED_KEYS);
			 ps.setString(1, user.getName());
			 ps.setString(2, user.getAddress());
			 ps.setString(3, user.getEmail());
			 int k=ps.executeUpdate();
			 try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                user.setId(generatedKeys.getInt(1));
		            }
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			Utils.closeConnection(con);
		}
		
		return user;
	}
	
	

	/*
	 * 
	 * @Autowired
	private JdbcTemplate jdbcTemplate;
	
	 * public User create(final User user) throws UserException {
		//System.out.println("inside UserDaoImpl");
		KeyHolder holder = new GeneratedKeyHolder();
		logger.info("inside userdao impl, with user >> "+user.getName() );

		try{
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, user.getName());
					ps.setString(2, user.getAddress());
					ps.setString(3, user.getEmail());
					return ps;
				}
			}, holder);
		}catch(Exception e){
			logger.error("exception occured in user dao impl>> "+e.getMessage());
			throw e;
		}
		int newUserId = holder.getKey().intValue();
		user.setId(newUserId);

		return user;
	}
*/
	
	
/*	public List<User> findAll() {
		return jdbcTemplate.query(FETCH_SQL, new UserMapper());
	}

	public User findUserById(int id) {
		return jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { id }, new UserMapper());
	}

}

class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("record_id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("address"));
		user.setEmail(rs.getString("email"));
		return user;
	}
*/

}
