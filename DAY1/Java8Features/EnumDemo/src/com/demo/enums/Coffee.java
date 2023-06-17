package com.demo.enums;

public enum Coffee {
	small(150,120),medium(200,250),big(250,350);
    private int size,price;
	private Coffee(int s, int p) {
		System.out.println("in cofee constructor");
		size=s;
		price=p;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
