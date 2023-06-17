package com.demo.threads;

import com.demo.beans.MyStorage;

public class MyProducer extends Thread{
	private MyStorage ms;
	
	public MyProducer(MyStorage ms) {
		super();
		this.ms = ms;
	}

	public void run() {
		
		for(int i=0;i<10;i++) {
			ms.setN(i);
		}
	}
	

}
