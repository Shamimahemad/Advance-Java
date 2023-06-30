package com.demo.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Student")
public class Student extends Person {
	private String course;
	private int marks;
	public Student() {
		super();
	}
	public Student(int id,String name,String course, int marks) {
		super(id, name);
		this.course = course;
		this.marks = marks;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return super.toString()+"Student [course=" + course + ", marks=" + marks + "]";
	}
  
	
}
