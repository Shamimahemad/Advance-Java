package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Student;
import com.demo.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getAll() {
		
		return studentDao.showAll();
	}

	@Override
	public boolean addNewStudent(int sid, String sname, String course, int marks, int year) {
		
		return studentDao.addnewstudent(sid,sname,course,marks,year);
	}

	@Override
	public Student getById(int sid) {
	return studentDao.getById(sid);
	}

	@Override
	public boolean updateStudent(int sid, String sname, String course, int marks, int year) {
		return studentDao.updatestudent(sid,sname,course,marks,year);
	}

	@Override
	public boolean delById(int sid) {
		
		return studentDao.deleteById(sid);
	}
}
