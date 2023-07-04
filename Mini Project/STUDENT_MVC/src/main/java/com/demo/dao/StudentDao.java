package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

public interface StudentDao {

	List<Student> showAll();

	boolean addnewstudent(int sid, String sname, String course, int marks, int year);

	Student getById(int sid);

	boolean updatestudent(int sid, String sname, String course, int marks, int year);

	boolean deleteById(int sid);

}
