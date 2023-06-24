package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.RegisterUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginService ls = new LoginServiceImpl();
		//int id =request.getParameter("id");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		LocalDate dt=LocalDate.parse(request.getParameter("dt"),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		String cityname=request.getParameter("city");
		String gender=request.getParameter("gender");
		String address=request.getParameter("add");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		RegisterUser ru=ls.addStudent(new RegisterUser(fname,lname,dt,cityname,gender,address,email,password));
		
		if(ru!=null) {
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		else {
			PrintWriter out =response.getWriter();
		     response.setContentType("text/html");
		     out.println("Registration failed...");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
	}

}
