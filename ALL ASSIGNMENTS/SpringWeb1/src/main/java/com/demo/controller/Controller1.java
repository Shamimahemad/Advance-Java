package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Controller1 {
	
	  @RequestMapping("/")
	  public String displayhomepage() {
	  System.out.println("in display login");
      return "index";
     }
	 
	
	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		String message="this is message from say hello";
		//message data can be accessed in hello.jsp page by name msg
		return new ModelAndView("hello","msg",message);
	}
	
	@RequestMapping("/login")
	public ModelAndView sayLogin() {
		String message="this is message from say hello login";
		//message data can be accessed in hello.jsp page by name msg
		return new ModelAndView("login","msg",message);
	}
	
	@RequestMapping("/signup")
	public ModelAndView signUp() {
		return new ModelAndView("signup","msg","Create Account..");
	};

}
