package com.demo.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person{
	
	private String dept;
	private String degs;
	public Employee() {
		super();
	}
	public Employee(int id,String name,String dept, String degs) {
		super(id,name);
		this.dept = dept;
		this.degs = degs;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDegs() {
		return degs;
	}
	public void setDegs(String degs) {
		this.degs = degs;
	}
	@Override
	public String toString() {
		return super.toString()+"Employee [dept=" + dept + ", degs=" + degs + "]";
	}
	

}
