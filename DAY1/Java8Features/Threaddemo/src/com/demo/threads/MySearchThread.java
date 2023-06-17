package com.demo.threads;

import com.demo.beans.MyFileReadr;

public class MySearchThread extends Thread{
	private MyFileReadr fr;
	private String s1;
	
	public MySearchThread(MyFileReadr fr, String s1) {
		super();
		this.fr = fr;
		this.s1 = s1;
	}

	public void run() {
		boolean status=fr.searchData("test.txt", s1);
		if(status) {
			System.out.println("found"+s1);
		}else {
			System.out.println("not found"+s1);
		}
	}

}
