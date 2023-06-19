package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
   private static Connection con;
   private static PreparedStatement psgetAll,addPro,getByName,getById,delbyID;
   
   static {

	   try {
		   con=DButils.getMyConnection();
		
		   psgetAll=con.prepareStatement("select * from product1;");
		   addPro=con.prepareStatement("insert into product1 values(?,?,?,?,?);");
		   getByName=con.prepareStatement("select * from product1 where pname=?;");
		   getById=con.prepareStatement("select * from product1 where id=?;");
		   delbyID=con.prepareStatement("delete from product1 where id=?;" );
		   
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	   
   }
	@Override
	public List<Product> getAll() {
		List<Product> lst=new ArrayList<>();
		try {
			ResultSet rs=psgetAll.executeQuery();
			while(rs.next()) {
				
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				lst.add(p);
			}
		} catch (SQLException e) {
			
		System.out.println(e);
		}
		return lst;
	}
	@Override
	public boolean addProduct() {
	
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Product Id");
			int id=sc.nextInt();
			System.out.println("Enter Product Name");
			String name=sc.next();
			System.out.println("Enter Product Price");
			int price=sc.nextInt();
			System.out.println("Enter Product QTY");
			int qty=sc.nextInt();
			System.out.println("Enter Product Expiry 'YYYY-MM-DD '..");
			String exp=sc.next();
			
			addPro.setInt(1, id);
			addPro.setString(2, name);
			addPro.setInt(3, price);
			addPro.setInt(4, qty);
			addPro.setString(5, exp);
			addPro.executeUpdate();
			return true;
		} 
		catch (SQLException e) {
			System.out.println(e);
			return false;
		}catch(InputMismatchException e) {
			System.out.println(e);
			return false;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	@Override
	public List<Product> getByName(String name) {
		List<Product> lst=new ArrayList<>();
		try {
			getByName.setString(1, name);
			ResultSet rs=getByName.executeQuery();
			while(rs.next()) {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				lst.add(p);
			}
			return lst;
		} catch (SQLException e) {
			System.out.println(e);
		}
				
		
		return null;
	}
	@Override
	public Product getById(int id) {
		Product p=null;
	  try {
		getById.setInt(1, id);
		ResultSet rs=getById.executeQuery();
		
		while(rs.next()) {
			 p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
			
		}
		return p;
	} catch (SQLException e) {
		System.out.println(e);
	}
		return null;
	}
	@Override
	public boolean deletebyID(int id) {
		try {
			delbyID.setInt(1, id);
			int st=delbyID.executeUpdate();
			if(st>0) {
				return true;
			}else {
			 return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
