package com.demo.dao;

import com.demo.beans.User;

public interface LoginDao {

	User getUser(String unm, String passwd);

	boolean createUsre(String unm, String passwd);

}
