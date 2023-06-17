package com.demo.test;

import com.demo.beans.MyClass;
import com.demo.threads.MyFactorialThread;

public class TestFactorial {

	public static void main(String[] args) {
		MyClass ob=new MyClass();
		//to  start runnable object we need to wrap the runnable object into thread.
		MyFactorialThread fr=new MyFactorialThread(ob, 5);
		Thread th=new Thread(fr);
		th.start();
		System.out.println("in main thread");
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th.start();

	}

}
