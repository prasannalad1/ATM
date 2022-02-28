package com.atm;

import java.sql.ResultSet;
import java.util.Scanner;


import com.atm.dao.BankUserDBOperation;


public class App 
{
	 public static void main( String[] args )
	    {
	    	System.out.println("==================================================================================");
	    	System.out.println("                             WELCOME TO ATM   "
	    			+ " Please Insert Card                                ");
	    	System.out.println("==================================================================================");
	    	
	    	boolean status=true;
	    	do
	    	{
	       try
	       {
	    	Scanner scan=new Scanner(System.in);
	    	
			System.out.println
			            ("Choose Anyone  "
			             + "1.English\r\n" 
		            	+ "2.Hindi\r\n"
		             	+ "3.marathi\r\n"
		            	+ "4.tamil\r\n"
		            	+ "5.telgu");
			
	    	int userType=scan.nextInt();
	    
	    	    	
	    	
	    if(userType==1)
	    	{
	    		BankUserDBOperation ob=new BankUserDBOperation();
	    		System.out.println("\t Enter Account Id:");
	    		long uId=scan.nextLong();
	    		System.out.println("\t Enter Password:");
	    		String password=scan.next();
	    		
	    		if(ob.login(uId, password))
	    		{
	    			System.out.println("============================================================================");
	    			System.out.println("                               logged in!!                                  ");
	    			System.out.println("============================================================================");
	    			
	    			
	    		
	    			
	    			
	    			
	    			
	    			
	    			System.out.println("\t\n"
	    					+ " 1.withdraw \r\n"
	    	    			+ "2.deposit \r\n"
	    	    			+"3.checkbalance\r\n"
	    	    			+"4.change Password \r\n"
	    	    		    +"5.Logout");
	    			int operation=scan.nextInt();
	    			if(operation==1)
	    			{
	    				System.out.println("Enter the withdrawal amount:");
	    				double withdrwalAmount=scan.nextDouble();
	    				System.out.println("============================================================================");
	    				ob.withdraw(withdrwalAmount, uId);
	    				System.out.println("============================================================================");
	    			}
	    			else if(operation==2)  //Deposit
	    			{
	    				System.out.println("Enter the Deposit amount:");
	    				double depositAmount=scan.nextDouble();
	    				System.out.println("============================================================================");
	    				ob.deposit(depositAmount, uId);
	    				System.out.println("============================================================================");
	    			}
	    			else if(operation==3)
	    			{
	    				System.out.println("============================================================================");
	    				ResultSet rs=ob.balanceCheck(uId);
	    				while(rs.next())
	    				{
	    					System.out.println("Available Balance:"+rs.getDouble(5));
	    				}
	    				System.out.println("============================================================================");
	    			}
	    			
	    			 else if(operation==4)
	    	       	{
	    	    		System.out.println("Enter new password:");
	    	    		String newPassword=scan.next();
	    	       		if(ob.changePassword(uId, newPassword))
	    	       		{
	    	       			System.out.println("====================================================================");
	    	    			System.out.println("                        Password changed successfully!!             ");
	    	    	       	System.out.println("====================================================================");

	    	       		}
	    	       		else
	    	       		{
	    	       			System.out.println("=====================================================================");
	    	    			System.out.println("                   Problem in password change!!                      ");
	    	    	       	System.out.println("=====================================================================");

	    	       		}
	    	       	}
	    			
	               else if(operation==5)
	    	       	{
	    	       		ob.logout();
	    	       		status=false;
	    	       		System.out.println("=======================================================================");
	        			System.out.println("                                      Logged Out!!                     ");
	        	       	System.out.println("=======================================================================");

	    	       	}
	    	    	else 
	    	       	{
	    	    		System.out.println("=======================================================================");
	        			System.out.println("                           Wrong Input!!                               ");
	        	       	System.out.println("=======================================================================");

	    	       	}
	    	       	
	    	       	
	    		}
	   
	    		
	  		
	    		else
	    		{
	    			System.out.println("============================================================================");
	    			System.out.println("                     User Id or Password Incorrect!!!                       ");
	    			System.out.println("============================================================================");

	    		}
	    		
	    	}
	    	else
	    	{
	    	   System.out.println("\t Please enter a correct input!!");
	    	}
	       
	     }
	       catch(Exception e)
	       {
	    	   System.out.println(e.getMessage());
	    	   System.out.println("\t Wrong Input!!");
	    	   System.out.println("\t Provide Number Input!!");
	    	   System.out.println("===============================================================================");
	       }
	    }
	    	while(status);
	    }
}
