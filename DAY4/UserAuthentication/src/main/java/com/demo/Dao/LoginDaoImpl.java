package com.demo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public class LoginDaoImpl implements LoginDao {

	private static Connection conn;
	private static PreparedStatement ps,getUser,addUser,psgetalluser;
	
	static {
		conn=DBUtils.getMyConnection();
		try {
			//ps=conn.prepareStatement("select * from user ");
			getUser=conn.prepareStatement("select * from user where uname=? and pass=?");
			psgetalluser=conn.prepareStatement("select * from student_registration");
			addUser=conn.prepareStatement("insert into student_registration values(default,?,?,?,?,?,?,?,?);");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MyUser validateUser(String uname, String pass) {
		
		try {
			MyUser user=null;
			getUser.setString(1, uname);
			getUser.setString(2, pass);
			ResultSet rs=getUser.executeQuery();
			if(rs.next()) {
			 user=new MyUser(rs.getString(1),rs.getString(2));}
			return user;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public RegisterUser addStudent(RegisterUser ru) {
		try {
			addUser.setString(1,ru.getFname());
			addUser.setString(2,ru.getLname());
			addUser.setString(3,ru.getEmail());
			addUser.setString(4,ru.getPassword());
			
			java.sql.Date date=java.sql.Date.valueOf(ru.getDate());
			
			addUser.setDate(5,date);
			addUser.setString(6,ru.getCityname());
			addUser.setString(7,ru.getGender());
			addUser.setString(8,ru.getAddress());
			int status =addUser.executeUpdate();
			if(status>0) {
				return ru;
				
			}
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RegisterUser> showAllProducts() {
		try {
			List<RegisterUser> rslist=new ArrayList<>();
			ResultSet rs =psgetalluser.executeQuery();
			while(rs.next()) {
				//LocalDate ldt=rs.getDate(6).toLocalDate();
				//String fname, String lname, LocalDate date, String cityname, String gender, String address,String email,String password
				LocalDate ldt=LocalDate.now();
				rslist.add(new RegisterUser(rs.getString(2),rs.getString(3),ldt,rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
			}
			return rslist;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
