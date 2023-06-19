package com.demo.Service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> displayAll();

	boolean addProduct();

	List<Product> displayByName(String name);

	Product displayById(int id);

	boolean deletebyID(int id);


	

}
