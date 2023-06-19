package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getAll();

	boolean addProduct();

	List<Product> getByName(String name);

	Product getById(int id);


	boolean deletebyID(int id);

	

}
