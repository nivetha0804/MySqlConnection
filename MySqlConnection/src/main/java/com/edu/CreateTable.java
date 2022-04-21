package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String mytable="Create table log(id int(4),name varchar(10))";
		//connection code
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb";
		String un="root";
		String pass="root";
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,un,pass);
			Statement st=con.createStatement();
			st.execute(mytable);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
