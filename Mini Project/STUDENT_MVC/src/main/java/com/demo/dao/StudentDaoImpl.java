package com.demo.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
    @Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> showAll() {
		List<Student> slist=jdbcTemplate.query("select * from studentmvc", (rs,num)->{
			
			Student s=new Student();
		     s.setSid(rs.getInt(1));
		     s.setSname(rs.getString(2));
		     s.setCourse(rs.getString(3));
		     s.setMarks(rs.getInt(4));
		     s.setYear(rs.getInt(5));
		     return s;
		});
		return slist;
	}

	@Override
	public boolean addnewstudent(int sid, String sname, String course, int marks, int year){
		try {
			int n=jdbcTemplate.update("insert into studentmvc values(?,?,?,?,?)", new Object[] {
					sid,sname,course,marks,year
			});
			return n>0;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public Student getById(int sid) {
		Student s=jdbcTemplate.queryForObject("select * from studentMVC where sid=?",new Object[] {sid},BeanPropertyRowMapper.newInstance(Student.class));
		
		return s;
	}

	@Override
	public boolean updatestudent(int sid, String sname, String course, int marks, int year) {
		int n=jdbcTemplate.update("update studentmvc set sname=?,course=?,marks=?,year=? where sid=?",new Object[] {sname,course,marks,year,sid});
		
		return n>0;
	}

	@Override
	public boolean deleteById(int sid) {
		int n=jdbcTemplate.update("delete  from studentmvc where sid=?", new Object[] {sid});
		return n>0;
	}
}
