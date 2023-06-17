package com.demo.test;

import com.demo.enums.Coffee;

public class TestEnum {
	public static void main(String[] args) {
		Coffee c=Coffee.medium;
		switch(c) {
		case small:
			System.out.println("small selected");
			System.out.println("price: "+c.getPrice());
			System.out.println("Size in ml "+c.getSize());
			break;
		case medium:
			System.out.println("medium selected");
			System.out.println("price: "+c.getPrice());
			System.out.println("Size in ml "+c.getSize());
			break;
		}
		System.out.println(c.ordinal());
		c.setPrice(3567);
		System.out.println(c.getPrice());
	}


}
