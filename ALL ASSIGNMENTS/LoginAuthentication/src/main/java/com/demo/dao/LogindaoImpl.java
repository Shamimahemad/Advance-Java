package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.UserLogin;

public class LogindaoImpl implements Logindao {

	private static Connection con;
	private static PreparedStatement pslogin;

	static {
		con = DBUtils.getMyConnection();
		try {

			pslogin = con.prepareStatement("select * from user11 where uname=? and password=?");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public UserLogin validateUser(String uname, String pass) {

		try {
			pslogin.setString(1, uname);
			pslogin.setString(2, pass);
			ResultSet rs = pslogin.executeQuery();
			while (rs.next()) {
				return new UserLogin(uname, pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
