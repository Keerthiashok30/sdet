package com.rmg.projecttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DEmo 
{
	
	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		try
		{
		//resgister to db
		Driver sqldriver=new Driver();  //com.mysql.cj.jdbc.Driver;
		
		DriverManager.registerDriver(sqldriver);
		
		//connect to db
		DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	
		
		//create statemnet refernce
				Statement stat = con.createStatement();
				
				//execute query
				ResultSet res = stat.executeQuery("select * from project");
				while(res.next())
				{
				System.out.println(res.getString(1)+"/t"+"/t"+res.getString(2)+"/t"+res.getString(3)+"/t"+res.getString(4)+"/t"+res.getString(5)+"/t"+res.getInt(6));
				}
	   }catch(SQLException e)
		{
		   System.err.println("inva;lid query");
		}

	finally
	{
		con.close();
	}
	
	
	}

}
