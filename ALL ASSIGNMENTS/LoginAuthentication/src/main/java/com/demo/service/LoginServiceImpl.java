package com.demo.service;

import com.demo.beans.UserLogin;
import com.demo.dao.Logindao;
import com.demo.dao.LogindaoImpl;

public class LoginServiceImpl implements LoginService{
	
	private Logindao ldao;
      
	public LoginServiceImpl() {
		super();
		this.ldao = new LogindaoImpl();
	}
	@Override
	public UserLogin validateUser(String uname, String pass) {
		
		return ldao.validateUser(uname,pass);
	}}
