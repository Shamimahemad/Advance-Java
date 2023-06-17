package com.demo.beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReadr {
	
	public boolean searchData(String fn, String search){
		try (BufferedReader br=new BufferedReader(new FileReader(fn));){
			String s=null;
			do {
				 s=br.readLine();
				 try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(search.equals(s)) {
					return true;
				}
				
			}while(s!=null);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
