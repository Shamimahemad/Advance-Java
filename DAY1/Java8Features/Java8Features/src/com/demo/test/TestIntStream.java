package com.demo.test;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestIntStream {
	public static void main(String[] args) {
		IntStream intst=IntStream.of(10,20,30,40,60,50);
		OptionalInt s=intst.filter(x->x<10).findFirst();
		if(s.isPresent())
		System.out.println(s.getAsInt());
	}
   
}
