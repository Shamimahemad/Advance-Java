package com.demo.dao;

import com.demo.beans.User;

public interface AdminDao {

	User getUser(String uname, String pass);

}
