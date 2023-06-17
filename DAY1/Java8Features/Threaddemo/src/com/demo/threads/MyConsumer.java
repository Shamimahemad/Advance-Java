package com.demo.threads;

import com.demo.beans.MyStorage;

public class MyConsumer extends Thread {
private MyStorage ms;
	
	public MyConsumer(MyStorage ms) {
		super();
		this.ms = ms;
	}

	public void run() {
		
		for(int i=0;i<10;i++) {
			ms.getN();
		}
	}
	
}
