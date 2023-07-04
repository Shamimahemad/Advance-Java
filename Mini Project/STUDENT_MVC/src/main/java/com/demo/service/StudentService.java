package com.demo.service;

import java.util.List;

import com.demo.beans.Student;

public interface StudentService {

	List<Student> getAll();

	boolean addNewStudent(int sid, String sname, String course, int marks, int year);

	Student getById(int sid);

	boolean updateStudent(int sid, String sname, String course, int marks, int year);

	boolean delById(int sid);

}
