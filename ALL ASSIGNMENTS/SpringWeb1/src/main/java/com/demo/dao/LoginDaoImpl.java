package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public User getUser(String unm, String passwd) throws EmptyResultDataAccessException{
		
		User u=jdbcTemplate.queryForObject("select * from User where uname=? and pass=?;",
				new Object[] {unm,passwd},BeanPropertyRowMapper.newInstance(User.class));
		
		return u;
	}
	@Override
	public boolean createUsre(String unm, String passwd) {
		int n=jdbcTemplate.update("insert into user values(?,?)",new Object[] {
				unm,passwd
		});
		return n>0;
	}

}
