package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;

public class TestMain {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		/*
		 * Session sess = sf.openSession(); Transaction tr = sess.beginTransaction();
		 * MyUser u1 = new MyUser(17, "Ayush", "ayushy12@gmail.com"); MyUser u2 = new
		 * MyUser(187, "Harshal", "harshal12@gmail.com"); sess.save(u1); sess.save(u2);
		 * tr.commit(); sess.close(); sf.close();
		 */
		Session sess = sf.openSession(); 
		Transaction tr = sess.beginTransaction();
		MyUser u1=sess.get(MyUser.class, 11);
		tr.commit(); sess.close(); sf.close();
		System.out.println(u1);
	}

}
