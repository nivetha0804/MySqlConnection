package com.edu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


public class InsertRecordsByUser1 
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
				Class.forName(driver); //load the driver  , here Class is the name of class
				conn=DriverManager.getConnection(url, un, pass);
				st=conn.createStatement();
				//from here
				while(true) 
				{
					System.out.println("Enter name");
					name=sc.next();
					System.out.println("Enter id");
					id=sc.nextInt();
					ins="insert into login01 values("+id+",'"+name+"')";
					int i=st.executeUpdate(ins);
					if(i>0) 
					{
					}
					else 
					{
						System.out.println("Not inserted");
					}
					System.out.println("Do you want to continue y/n");
					char ch=sc.next().charAt(0);
					if(ch=='n') {
						break;
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

