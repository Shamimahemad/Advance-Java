package com.demo.test;

import com.demo.beans.MyClass;
import com.demo.threads.MyThread;

public class TestMain {

	public static void main(String[] args) {
		MyClass ob=new MyClass();
		MyClass ob1=new MyClass();
		MyThread th1=new MyThread(ob,5);
		//th1.setDaemon(true);
		MyThread th2=new MyThread(ob,7);
		MyThread th3=new MyThread(ob1,9);
		th1.setPriority(Thread.NORM_PRIORITY+3);
		th1.start();
		th2.start();
		th3.start();
		System.out.println("main method logic");
		try {
			th1.join(400);
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        System.out.println("main ends");
	}

}
