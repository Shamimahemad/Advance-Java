package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.College;
import com.demo.beans.Student;

public class TestOneToOne {

	public static void main(String[] args) {


		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		College c1=new College(40,"CDAC","Noida");
		Student s1=new Student(10, "Ayush", "DBDA",c1);
		sess.save(s1);
		tr.commit();
		sess.close();
		sf.close();

	}

}
