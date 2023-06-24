package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
    LoginService ls=new LoginServiceImpl();
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		MyUser user=ls.validateUser(uname,pass);
		if(user==null) {
			out.println("<h2>Invalid Credentials...</h2>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
	}else {
		
		RequestDispatcher rd=req.getRequestDispatcher("afterLogin.html");
		HttpSession session=req.getSession();
		
			session.setAttribute("user", user);
		
		rd.forward(req, res);
	}
		
		
	}
	
}
