package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.Random;



public class BankUserDBOperation {
	//database connection
		Databaseconnection ob=new Databaseconnection();
		Connection conn=ob.connection();

	//login
		public boolean login(long accid,String password) throws SQLException
		{
			
			
			PreparedStatement stmt=conn.prepareStatement("select * from useratm where userId=? and password=? ");
			stmt.setLong(1, accid);
			stmt.setString(2, password);
			
			ResultSet result=stmt.executeQuery();
			if(result.next()) //true or false
			{
			return true;
			}
			else
			{
				return false;
			}
		}
		
	//logout
		public void logout() throws SQLException
		{
			conn.close();
			
		}
		
	//change password
		public boolean changePassword(long accid,String newPassword) throws SQLException
		{
			PreparedStatement stmt=conn.prepareStatement("update useratm set password=? where userId=? ");
			stmt.setString(1,newPassword);
			stmt.setLong(2, accid);
			int affectedRows=stmt.executeUpdate();
			if(affectedRows>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
	//deposit	
		synchronized public void deposit(double depositAmount,long userid)
		{
			try
			{
			PreparedStatement stmt=conn.prepareStatement("select * from useratm where userId=?");
			stmt.setLong(1, userid);
			ResultSet result=stmt.executeQuery();
			double availableBalance=0.0;
			while(result.next())
			{
				availableBalance=result.getDouble(5); // table me alance 5pe hai so
			}
			availableBalance=availableBalance + depositAmount;
			
			PreparedStatement stmt1=conn.prepareStatement("update useratm set balance=? where userId=? ");
			stmt1.setDouble(1, availableBalance);
			stmt1.setLong(2, userid);
			int affectedRows=stmt1.executeUpdate();
			if(affectedRows>0)
			{
				System.out.println("Deposit Successfully!!!");
				System.out.println("Available Balance:"+availableBalance);
			}
			else
			{
				System.out.println("Problem in deposit operation!!!");
			}
			}
			catch(Exception e)
			{
				System.out.println("Something went worng!!");
			}
		}
		
		
	//withdrawal	
		synchronized public void withdraw(double withdrwalAmount,long userid)
		{
			try
			{
			PreparedStatement stmt=conn.prepareStatement("select * from useratm where userId=?");
			stmt.setLong(1, userid);
			ResultSet result=stmt.executeQuery();
			double availableBalance=0.0;
			while(result.next())
			{
				availableBalance=result.getDouble(5); // table me alance 5pe hai so
			}
			  if(withdrwalAmount<=availableBalance)
			 {
				availableBalance=availableBalance -withdrwalAmount;
				PreparedStatement stmt1=conn.prepareStatement("update useratm set balance=? where userId=? ");
				stmt1.setDouble(1, availableBalance);
				stmt1.setLong(2, userid);
				int affectedRows=stmt1.executeUpdate();
				if(affectedRows>0)
				{
					System.out.println("withdrowal Successfully!!!");
					System.out.println("Remaining Balance:"+availableBalance);
				}
				else
				{
					System.out.println("Problem in withdrawal operation!!!");
				}
			}
			else
			{
				System.out.println("sufficient balance not available!!!!");
			}
		
			
			}
			catch(Exception e)
			{
				System.out.println("Something went worng!!");
			}
		}
		
		
	
	//Balance check
	   
	   public ResultSet balanceCheck(long accid)
	   {
		   ResultSet rs=null;
		   try
		   {
		   PreparedStatement pr=conn.prepareStatement("select * from useratm where userId=? ");
		   pr.setLong(1, accid);
		   rs=pr.executeQuery();
		   }
		   catch(Exception e)
		   {
			   System.out.println("something went wrong!!!");
		   }
		   return rs;
	   }
		
}
