package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProduct {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
     ProductService ps=new ProductServiceImpl();
		do {
			System.out.println("\n1.AddNewProduct \n2.DeleteById \n3.SearchById \n4.UpdateProduct");
			System.out.println("5.SortByPrice \n6.DisplayAllProduct \n0.Exit \nEnter your Choice...");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				boolean status=ps.addProduct();
				if(status) {
					System.out.println("Product Added Successfully");
				}else {
					System.out.println("failed to add...");
				}
				
				break;
			case 2:
				System.out.println("Enter Product Id");
				int pid=sc.nextInt();
				status=ps.deleteById(pid);
				if(status) {
					System.out.println("Product Deleted Successfully");
				}else {
					System.out.println("ID Not Found...");
				}
				
				break;
			case 3:
				System.out.println("Enter Product Id");
				pid=sc.nextInt();
				Product p=ps.searchById(pid);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("ID Not Found...");
				}
				break;
			case 4:
				System.out.println("Enter Product Id");
				pid=sc.nextInt();
				System.out.println("enter Product Name");
				String pname=sc.next();
				System.out.println("enter Product price");
				float price=sc.nextFloat();
				System.out.println("enter Product QTY");
				int qty=sc.nextInt();
				status=ps.updateProduct(pid,pname,price,qty);
				if(status) {
					System.out.println("Product Updated Successfully");
				}else {
					System.out.println("ID Not Found...");
				}
				break;
			case 5:
				List<Product> plist=ps.sortByPrice();
				plist.forEach(System.out::println);
				break;
			case 6:
				plist=ps.getAll();
				plist.forEach(System.out::println);
				break;
			
				default :
					System.out.println("invalid choice..");
				break;
			case 0:
				ps.closeMySessionFactory();
				
				break;
			}
			
		}while(choice!=0);
	}

}
