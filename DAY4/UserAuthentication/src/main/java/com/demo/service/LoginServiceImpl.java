package com.demo.service;

import java.util.List;

import com.demo.Dao.LoginDao;
import com.demo.Dao.LoginDaoImpl;
import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public class LoginServiceImpl implements LoginService{
    
	LoginDao ldao=new LoginDaoImpl();
	@Override
	public MyUser validateUser(String uname, String pass) {
		
		return ldao.validateUser(uname,pass);
	}
	@Override
	public RegisterUser addStudent(RegisterUser registerUser) {
		
		return ldao.addStudent(registerUser);
	}
	@Override
	public List<RegisterUser> getAllProduct() {
	
		return ldao.showAllProducts();
	}

}
