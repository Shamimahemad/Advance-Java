package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.UserLogin;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		LoginService ls=new LoginServiceImpl();
		UserLogin u=ls.validateUser(uname,pass);
		
		if(u==null) {
			out.println("<h3>invalid credentials</h3>");
		}else {
			out.println("<h3>Successful login</h3>");
		}
	}

}
