package com.demo.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="college")

public class Student {
	@Id
	private int sid;
	private String sname;
	private String course;
	@Embedded
	private College college;

	public Student(College college) {
		super();
		this.college = college;
	}

	public Student() {
		super();
	}

	public Student(int sid, String sname, String course, College college) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.course = course;
		this.college = college;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", course=" + course + ", college=" + college + "]";
	}
	

}
