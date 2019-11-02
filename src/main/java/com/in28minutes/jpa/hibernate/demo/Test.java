package com.in28minutes.jpa.hibernate.demo;

import java.sql.DriverManager;

public class Test 
{
	public static void main(String[] args) 
	{
		String jdbcUrl="jdbc:mysql://192.168.43.143:3306/world?useSSL=false";
		String user="root";
		String password="April@2019";
		try
		{
			System.out.println("Connecting to db");
			DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Successful connection");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
