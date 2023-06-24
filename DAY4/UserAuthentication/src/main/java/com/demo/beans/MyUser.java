package com.demo.beans;

public class MyUser {
   
	private String uname;
	private String pass;
	public MyUser() {
		super();
	}
	public MyUser(String uname, String pass) {
		super();
		this.uname = uname;
		this.pass = pass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "MyUser [uname=" + uname + ", pass=" + pass + "]";
	}
	
}
