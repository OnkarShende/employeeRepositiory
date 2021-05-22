package com.wcs.app.MvcCrud.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCConnection 
{
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/04_May_MVC_Employee_Project";
	public static final String USER="root";
	public static final String PASSWORD="root";
	
	public static Connection con=null;
	public static PreparedStatement pr=null;
	

	public static PreparedStatement getPreparedStatement(String sql)
	{
		try
		{
			Class.forName(DRIVER);
			
		con=DriverManager.getConnection(URL,USER,PASSWORD);
		
		pr=con.prepareStatement(sql);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pr;
		
	}
	
	public void destroy()
	{
		try
		{
		pr.close();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
