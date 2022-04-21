package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecord 
{
	public static void main(String[] args) {
		//Connection 
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb"; //edudb is the database name of mysql
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pass);
			st=conn.createStatement();

			String sql="select * from login01";
			rs=st.executeQuery(sql);
			System.out.println("ID\tNAME");
			while(rs.next()) {
				int id=rs.getInt(1);
				String n=rs.getString(2);
				System.out.println(id+"\t"+n);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}				
	}
}

