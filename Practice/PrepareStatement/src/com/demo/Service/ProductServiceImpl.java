package com.demo.Service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
   private ProductDao pd;
		public ProductServiceImpl() {
			super();
			this.pd=new ProductDaoImpl();
		}
		
	
	@Override
	public List<Product> displayAll() {
		
		return pd.getAll();
	}
	@Override
	public boolean addProduct() {
	
		return pd.addProduct();
	}


	@Override
	public List<Product> displayByName(String name) {
		
		return pd.getByName(name);
	}


	@Override
	public Product displayById(int id) {
		
		return pd.getById(id);
	}


	@Override
	public boolean deletebyID(int id) {
		// TODO Auto-generated method stub
		return pd.deletebyID(id);
	}
	

}
