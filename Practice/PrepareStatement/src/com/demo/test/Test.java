package com.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.Service.ProductService;
import com.demo.Service.ProductServiceImpl;
import com.demo.beans.Product;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ProductService ps=new ProductServiceImpl();
		int choice=0;
		do {
			
			boolean stat=true;
			while(stat) {
				try {
					System.out.println(
							"1.Show all Products\n2.Add New Product\n3.Serach by Name\n4.Search by ID\n5.delete by ID\n6.Update Product details\nEnter choice...");
					choice = sc.nextInt();
					stat=false;
				}catch (Exception e) {
					sc.nextLine();
					System.out.println("Enter Valid choice !!");
					
				}
			}
			
			switch(choice) {
			case 0:
				sc.close();
				System.out.println("thank you for visiting...");
				break;
			case 1:
				List<Product> lst=new ArrayList<>();
				lst=ps.displayAll();
				lst.forEach(p-> System.out.println(p));
				break;
			case 2:
				boolean status=ps.addProduct();
				if(status)
					System.out.println("Product Added");
				else
					System.out.println("Failed TO Add Product");
				break;
			case 3:
				lst=new ArrayList<>();
				System.out.println("Enter Name");
				String name=sc.next();
				lst=ps.displayByName(name);
				lst.forEach(p-> System.out.println(p));
				break;
			case 4:
				System.out.println("Enter ID");
				int id=sc.nextInt();
				Product p=ps.displayById(id);
				System.out.println(p);
				break;
			case 5:
				System.out.println("Enter ID");
				id=sc.nextInt();
				 status= ps.deletebyID(id);
				if(status) {
					System.out.println("Deleted Sucessfully");
				}else {
					System.out.println("Id not found");
				}
				break;
			case 6:
				break;
			}
			
		}while(choice!=0);

	}

}
