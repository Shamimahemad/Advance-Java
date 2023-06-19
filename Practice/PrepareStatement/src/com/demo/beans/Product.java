package com.demo.beans;

public class Product {
private int pid;
private String pname;
private int qty;
private int price;
private String date;

public Product(int pid, String pname, int qty, int price, String date) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.qty = qty;
	this.price = price;
	this.date = date;
}

public Product() {
	super();
	this.pid = 0;
	this.pname = null;
	this.qty = 0;
	this.price = 0;
	this.date =null;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public int getQty() {
	return qty;
}

public void setQty(int qty) {
	this.qty = qty;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", date=" + date + "]";
}


}
