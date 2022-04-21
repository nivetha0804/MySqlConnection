package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FetchRecord 
{
	public static void main(String[] args) 
	{
		//based on id fetch the record
		//Connection 
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb"; //edudb is the database name of mysql
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to fetch record");
		int id = sc.nextInt();
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pass);
			st=conn.createStatement();
			String sql="select * from login01 where id="+id; //get only one row
			rs=st.executeQuery(sql);
			if(rs.next()) 
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}else 
			{
				System.out.println("user not exists");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		sc.close();
	}
}
