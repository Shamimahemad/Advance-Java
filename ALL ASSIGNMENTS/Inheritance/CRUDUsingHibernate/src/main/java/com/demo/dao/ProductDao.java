package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean addProduct(Product p);

	boolean deleteById(int pid);

	Product findById(int pid);

	boolean modifiProduct(int pid, String pname, float price, int qty);

	List<Product> sortByPrice();

	List<Product> displayAll();

	void closeMySessionFactory();

}
