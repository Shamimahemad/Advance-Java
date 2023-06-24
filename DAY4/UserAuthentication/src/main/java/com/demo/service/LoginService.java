package com.demo.service;

import java.util.List;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public interface LoginService {

	MyUser validateUser(String uname, String pass);

	RegisterUser addStudent(RegisterUser registerUser);

	List<RegisterUser> getAllProduct();

}
