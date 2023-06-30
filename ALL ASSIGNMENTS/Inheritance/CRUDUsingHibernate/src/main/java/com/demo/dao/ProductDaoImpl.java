package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Product;
import org.hibernate.Query;

public class ProductDaoImpl implements ProductDao {
	
	private static SessionFactory sf;
	static {
	
	 sf=HibernateUtil.getMySessionFactory();
	
	}
	public boolean addProduct(Product p) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(p);
		tr.commit();
		sess.close();
		return true;
	}
	public boolean deleteById(int pid) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		if(p!=null) {
			sess.delete(p);
			tr.commit();
			sess.close();
			return true;
		}
		tr.commit();
		sess.close();
		return false;
	}
	public Product findById(int pid) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		tr.commit();
		sess.close();
		return p;
	}
	public boolean modifiProduct(int pid, String pname, float price, int qty) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		if(p!=null) {
		p.setPname(pname);
		p.setPrice(price);
		p.setQty(qty);
		sess.update(p);
		tr.commit();
		sess.close();
		return true;
		}
		tr.commit();
		sess.close();
		return false;
	}
	@Override
	public List<Product> sortByPrice() {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		
		Query query=sess.createQuery("from Product p order by p.pname");
		List<Product> plist=query.list();
		tr.commit();
		sess.close();
		if(plist==null) {
			System.out.println("plist is empty");
		}
		return plist;
	}
	@Override
	public List<Product> displayAll() {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Query query=sess.createQuery("from Product");
		List<Product> plist=query.list();
		tr.commit();
		sess.close();
		return plist;
	}
	@Override
	public void closeMySessionFactory() {
		
		HibernateUtil.closeMySessionFactory();
		
	}
}
