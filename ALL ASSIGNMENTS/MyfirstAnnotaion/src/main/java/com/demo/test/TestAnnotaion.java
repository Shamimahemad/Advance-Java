package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;



public class TestAnnotaion {

	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		/*
		 * Product p1=new Product(2,"Cake",30); sess.save(p1); tr.commit();
		 * sess.close(); sf.close();
		 */
      
		Product p1=sess.get(Product.class, 1);
		System.out.println(p1);
		tr.commit();
		sess.close();
		sf.close();
		
	}

}
