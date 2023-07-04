package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.User;
import com.demo.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
	AdminDao adminDao;

	@Override
	public User getUser(String uname, String pass) {
		
		return adminDao.getUser(uname,pass);
	}
}
