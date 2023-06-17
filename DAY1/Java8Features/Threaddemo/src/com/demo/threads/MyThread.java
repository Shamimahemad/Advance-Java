package com.demo.threads;

import com.demo.beans.MyClass;

public class MyThread extends Thread{
	private MyClass ob;
	private int n;
	
	public MyThread(MyClass ob, int n) {
		super();
		this.ob = ob;
		this.n = n;
	}

	public void run() {
		ob.printTable(n);
	}

}
