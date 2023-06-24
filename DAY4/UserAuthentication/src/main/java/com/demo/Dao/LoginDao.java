package com.demo.Dao;

import java.util.List;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public interface LoginDao {

	MyUser validateUser(String uname, String pass);

	RegisterUser addStudent(RegisterUser registerUser);

	List<RegisterUser> showAllProducts();

	

}
