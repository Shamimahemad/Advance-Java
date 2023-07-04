package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.User;
import com.demo.service.AdminService;

@Controller
//@RequestMapping("/mylogin")
public class LoginController {
	@Autowired
    AdminService adminService;
	
	/*
	 * @RequestMapping("/") public ModelAndView toIndex() { return new
	 * ModelAndView("index","msg",null); }
	 */
	
	@RequestMapping("/login")
	public ModelAndView toLoginPage() {
		return new ModelAndView("login","msg",null);
	}
	
	@PostMapping("/validate")
	public ModelAndView validate(HttpSession session,@RequestParam("uname") String uname,@RequestParam("pass") String pass) {
	
		User u=adminService.getUser(uname,pass);
		String s="Welcome,"+" "+uname;
		if(u!=null) {
			 //return new ModelAndView("product/viewProduct");
			return new ModelAndView("redirect:/student/studentlist","welcome",s);
		}
		
		return new ModelAndView("login","msg","Invalid Credentials...");
	}
}
