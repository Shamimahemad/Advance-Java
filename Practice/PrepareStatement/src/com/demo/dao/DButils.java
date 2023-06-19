package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {

	private static Connection con;
	public static Connection getMyConnection(){
		
		try {
			
			if(con==null) {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver() );
			//step--2
				String url="jdbc:mysql://192.168.10.150:3306/dac32";
				
				con=DriverManager.getConnection(url,"dac32","welcome");
				if(con!=null) {
					System.out.println("connection done successfuly...");
					
				}
				else {
					System.out.println("connection failed..");
					
				}
			}
			return con;
		} 
		catch (SQLException e) {
			System.out.println("error occured");
			return null;
		}
		
		
	}
	
	public static void closeConnection() {
		try {
			if(con!=null)
			   con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
