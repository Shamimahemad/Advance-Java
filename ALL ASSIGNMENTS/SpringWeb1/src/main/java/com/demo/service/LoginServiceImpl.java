package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.User;
import com.demo.dao.LoginDao;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	@Override
	public User getUser(String unm, String passwd) {
		return loginDao.getUser(unm,passwd);
	}
	@Override
	public boolean createUser(String unm, String passwd) {
		
		return loginDao.createUsre(unm,passwd);
	}

}
