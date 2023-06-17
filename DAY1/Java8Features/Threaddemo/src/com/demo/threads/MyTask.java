package com.demo.threads;

import java.util.concurrent.Callable;

public class MyTask implements Callable<Integer>{
	private int start,stop;
	
	public MyTask(int start, int stop) {
		super();
		this.start = start;
		this.stop = stop;
	}

	public Integer call() {
		int s=0;
		System.out.println(start+"---"+stop+"-----"+Thread.currentThread().getId());
		for(int i=start;i<=stop;i++) {
			s=s+i;
		}
		return s;
	}

}
