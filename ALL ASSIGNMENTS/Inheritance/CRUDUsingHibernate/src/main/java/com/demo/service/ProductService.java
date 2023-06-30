package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addProduct();

	boolean deleteById(int pid);

	Product searchById(int pid);

	boolean updateProduct(int pid, String pname, float price, int qty);

	List<Product> sortByPrice();

	List<Product> getAll();

	void closeMySessionFactory();

}
