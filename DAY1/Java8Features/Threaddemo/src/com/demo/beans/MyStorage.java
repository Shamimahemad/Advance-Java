package com.demo.beans;

public class MyStorage {
	private int n;
	private boolean flag;
	
	public MyStorage() {
		super();
		flag=false;
	}
	synchronized public void setN(int n) {
		if(flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//producer logic goes here
		this.n=n;
		System.out.println("Put "+n);
		
		//it is synchronizing the thread
		flag=true;
		notify();
	}
	synchronized public void getN() {
		if(!flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//the consumer logic goes here
		System.out.println("got "+n);
		flag=false;
		notify();
	}

}
