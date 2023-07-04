package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;

@Repository
public class AdminDaoImpl implements AdminDao{
    @Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUser(String uname, String pass) {
		User u=jdbcTemplate.queryForObject("select * from user where uname=? and pass=?",new Object[] {uname,pass},
				BeanPropertyRowMapper.newInstance(User.class));
		return u;
	}
}
