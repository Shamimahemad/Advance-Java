package com.demo.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection conn;

	public static Connection getMyConnection() {

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.150:3306/dac32";
			conn = DriverManager.getConnection(url,"dac32" , "welcome");
			if (conn != null) {
				
				if (conn != null) {
					System.out.println("Connection Done!!!");

				}
			}
			return conn;
		} 
		catch (SQLException e) {
			System.out.println("Error Occured...");
			return null;
		}

	}
	
	public static void closeMyConnection() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("There is no connection to close...");
			}
		}
	}

}
