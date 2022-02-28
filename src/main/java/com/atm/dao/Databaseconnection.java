package com.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {
	public Connection connection()
	{
		Connection conn=null;	
		String databaseUrl="jdbc:mysql://localhost:3306/atmapp";
		String userName="root";
		String userPassword="";
		
		
			try {
				conn=DriverManager.getConnection(databaseUrl, userName, userPassword);
				
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();  //
			}
			
		return conn;
	}
	

}
