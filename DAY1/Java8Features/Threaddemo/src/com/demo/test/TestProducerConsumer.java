package com.demo.test;

import com.demo.beans.MyStorage;
import com.demo.threads.MyConsumer;
import com.demo.threads.MyProducer;

public class TestProducerConsumer {

	public static void main(String[] args) {
		MyStorage ms=new MyStorage();
		MyProducer p=new MyProducer(ms);
		MyConsumer c= new MyConsumer(ms);
		p.start();
		c.start();
	}

}
