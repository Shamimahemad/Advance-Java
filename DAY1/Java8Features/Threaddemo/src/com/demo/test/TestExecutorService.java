package com.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.demo.threads.MyTask;
public class TestExecutorService {

	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(5);
		List<Future> flist=new ArrayList<>();
		for(int i=1;i<=91;i=i+10) {
			MyTask t1=new MyTask(i,i+9);
			Future f=es.submit(t1);
			flist.add(f);
		}
		int sum=0;
		for(Future f:flist) {
			try {
				sum=sum+(int)f.get();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Sum : "+sum);
		try {
			es.awaitTermination(500,TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}










