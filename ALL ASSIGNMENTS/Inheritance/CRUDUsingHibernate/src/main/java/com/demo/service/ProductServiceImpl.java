package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	
	private ProductDao pdao;
	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}

	public boolean addProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Product Id");
		int pid=sc.nextInt();
		System.out.println("enter Product Name");
		String pname=sc.next();
		System.out.println("enter Product price");
		float price=sc.nextFloat();
		System.out.println("enter Product QTY");
		int qty=sc.nextInt();
		
		Product p=new Product(pid,pname,price,qty);
		
		return pdao.addProduct(p);
	}

	public boolean deleteById(int pid) {
		
		return pdao.deleteById(pid);
	}

	public Product searchById(int pid) {
		
		return pdao.findById(pid);
	}

	public boolean updateProduct(int pid, String pname, float price, int qty) {
		
		return pdao.modifiProduct(pid,pname,price,qty);
	}

	@Override
	public List<Product> sortByPrice() {
	
		return pdao.sortByPrice();
	}

	@Override
	public List<Product> getAll() {
		
		return pdao.displayAll();
	}

	@Override
	public void closeMySessionFactory() {
		
		pdao.closeMySessionFactory();
		
	}

	

}
