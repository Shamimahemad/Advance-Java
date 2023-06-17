package com.demo.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDate {
	public static void main(String[] args) {
		Date dt=new Date();
		GregorianCalendar gc=new GregorianCalendar(2023, 11,13);
		System.out.println(gc);
		//to get current data
		LocalDate ldt=LocalDate.now();
		LocalDateTime l1=LocalDateTime.now();
		System.out.println("date time"+l1);
		LocalDate ldt1=LocalDate.of(2023,11,22);
		String s="22/11/2023";
		System.out.println(LocalDate.parse(s,DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(ldt1);
		System.out.println(ldt1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
	}

}
