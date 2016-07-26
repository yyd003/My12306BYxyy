package com.neuedu.my12306.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/my12306?charset=utf8";
			String user = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			System.out.println("SQLerror!");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFounderror!");
		}
		return conn;
	}
	
	public static void beginTransaction(Connection conn){
    	try{
    		conn.setAutoCommit(false);
    	}catch(SQLException e){
    		System.out.println("beginTransaction error!");
    	}
    }
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			//throw new ServiceException("Can not commit transaction", e);
			System.out.println("commit error!");
		}
	}

    
    public static void rollBack(Connection conn)
    {
    	try{
    		conn.rollback();
    		conn.setAutoCommit(true);
    	}catch(SQLException e){
    		System.out.println("rollBack error!");
    	}
    }
    
	public static void closeStatement(ResultSet r, Statement s)
	{
       try{
		if (r != null)
			r.close();
		if (s != null)
			s.close();
       }catch(SQLException e){
    	   System.out.println("closeStatement error!");
       }

	}

	public static void closeConnection(Connection c) {
		try{
		if (c != null)
			c.close();
	}catch(SQLException e){
		System.out.println("closeConnection error!");
		}
	}
}
