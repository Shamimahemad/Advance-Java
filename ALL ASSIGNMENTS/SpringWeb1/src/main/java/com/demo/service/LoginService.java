package com.demo.service;

import com.demo.beans.User;

public interface LoginService {

	User getUser(String unm, String passwd);

	boolean createUser(String unm, String passwd);

}
