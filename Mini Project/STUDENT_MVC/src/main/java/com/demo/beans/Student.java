package com.demo.beans;

public class Student {
	private int sid;
	private String sname;
    private String course;
    private int marks;
    private int year;
	public Student() {
		super();
	}
	public Student(int sid, String sname, String course, int marks, int year) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.course = course;
		this.marks = marks;
		this.year = year;
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
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", course=" + course + ", marks=" + marks + ", year=" + year
				+ "]";
	}
    

}
