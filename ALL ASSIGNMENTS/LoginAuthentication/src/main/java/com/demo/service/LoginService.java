package com.demo.service;

import com.demo.beans.UserLogin;

public interface LoginService {



	

	UserLogin validateUser(String uname, String pass);

}
