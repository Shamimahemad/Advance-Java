package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculate")
public class calculateServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		int num1=Integer.parseInt(request.getParameter("num1"));
		String btn=request.getParameter("btn");
		
		switch(btn) {
		case "add":
			int num2=Integer.parseInt(request.getParameter("num2"));
			out.println("<h3>Addition :"+(num1+num2)+"</h3>");
			break;
		case "fact":
			 num1=Integer.parseInt(request.getParameter("num1"));
			   int fact=1;
			   for(int i=1;i<=num1;i++) {
				   fact=fact*i;
			   }
			   out.println("<h3>Factorial :"+(fact)+"</h3>");
			break;
		}
	}

}
