package com.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamFunctions {
  public static void main(String[] args) {
	List<String> lst=new ArrayList<>();
	lst.add("Hello");
	lst.add("welcome");
	lst.add("testing");
	lst.stream().forEach(System.out::println);
	System.out.println("**********************************");
	List<String> lst2=lst.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
	System.out.println(lst2);
	Optional<String> s=lst.stream().reduce((acc, num)->acc+num);
	if(s.isPresent()) {
	   System.out.println(s.get());
	 List<Integer> lst1=new ArrayList<>();
	 lst1.stream().map(x->x*x).findFirst();
	}
}
}
