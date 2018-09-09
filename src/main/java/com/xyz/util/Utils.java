package com.xyz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {

	
	public static Connection  getConnection() throws UserException{
		Connection conn=null;
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
		    System.out.println("CONNECTED" + '\n');
		    } catch (Exception e) {
		    	System.out.println(e.getMessage() + '\n');
		    }
		return conn;
	}
	
	
	public static void closeConnection(Connection conn) throws UserException{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
