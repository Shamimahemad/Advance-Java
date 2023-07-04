package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.AdminService;

@Controller
@RequestMapping("/")
public class Index {
	
	
	 @RequestMapping("/")
	  public String displayhomepage() {
	  System.out.println("in display login");
     return "index";
    }
	 
	
}
