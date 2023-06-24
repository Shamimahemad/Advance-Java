package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

@WebServlet("/productList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MyUser u=(MyUser)session.getAttribute("user");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(u!=null) {
			List<RegisterUser> rulist= new ArrayList<>();
			LoginService ls= new LoginServiceImpl();
			rulist=ls.getAllProduct();
			RequestDispatcher rd=request.getRequestDispatcher("Product.html");
		
			rd.include(request, response);
	
			for(RegisterUser ru:rulist) {
				out.println("<div class=\"card\" style=\"width: 18rem;\">\r\n"
					   
						+ "        <div class=\"card-body\">\r\n"
						+ "          <h5 class=\"card-title\">"+ru.getFname()+" "+ru.getLname()+"</h5>\r\n"
						+"           <h5 class=\"card-title\">"+ru.getGender()+"</h5>\r\n"
						+"           <h5 class=\"card-title\">"+ru.getEmail()+"</h5>\r\n"
						+ "          <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\r\n"
						+ "          <a href=\"#\" class=\"btn btn-primary\">Go somewhere</a>\r\n"
						+ "        </div>\r\n"
						+ "      </div>");
			}
			out.println("  </body>\r\n"
					+ "</html>");
			
		}
		
	}

}
