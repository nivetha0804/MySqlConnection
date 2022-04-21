package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DataExistOrNot 
{
	public static void main(String[] args) 
	{
		//Connection 
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb"; //edudb is the database name of mysql
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		String name=null;
		int id=0;
		Scanner sc=new Scanner(System.in);
		String ins=null;
		try 
		{
			Class.forName(driver); 
		    conn=DriverManager.getConnection(url, un, pass);
		    st=conn.createStatement();
		    //from here
		    while(true) 
		    {
		    System.out.println("Enter name");
		    name=sc.next();
		    System.out.println("Enter id");
		    id=sc.nextInt();
		    String sql="select * from login01 where id="+id;
		    ResultSet rs=st.executeQuery(sql); 
		    if(!rs.next()) 
		    {	    
		    ins="insert into login01 values("+id+",'"+name+"')";	                                
		    int i=st.executeUpdate(ins);
		    if(i>0) 
		    {
		    	System.out.println("Record is inserted successfully");
		    }
		    else 
		    {
		    	System.out.println("Not inserted");
		    }
		    System.out.println("Do you want to continue yes/no");
		    String ch=sc.next();
		    if(ch.equalsIgnoreCase("n")) 
		    {
		    	break;
		    }
		    }
		    else 
		    {
		    	System.out.println("Id exists choose another id");
		    }
		    }
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
      System.out.println("End of the program");
      sc.close();
	}
}
