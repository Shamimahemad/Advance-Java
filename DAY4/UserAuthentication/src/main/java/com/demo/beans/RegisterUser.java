package com.demo.beans;

import java.time.LocalDate;
import java.util.Date;

public class RegisterUser {


	private String fname;
	private String lname;
    private LocalDate date;
	private String cityname;
	private String gender;
	private String address;
	private String email;
	private String password;
	public RegisterUser() {
		super();
	}
	public RegisterUser( String fname, String lname, LocalDate date, String cityname, String gender, String address,String email,String password) {
		super();
	
		this.fname = fname;
		this.lname = lname;
		this.date = date;
		this.cityname = cityname;
		this.gender = gender;
		this.address = address;
		this.password=password;
		this.email=email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "RegisterUser [ fname=" + fname + ", lname=" + lname + ", date=" + date + ", cityname="
				+ cityname + ", gender=" + gender + ", address=" + address + "]";
	}
	
}
