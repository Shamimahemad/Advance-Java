package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.User;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/mylogin")
public class LoginController {
	@Autowired
LoginService ls;
	@PostMapping("/validate")
	public ModelAndView validateUser(HttpSession session,@RequestParam("uname") String unm,@RequestParam String passwd) {
		try {
			User u=ls.getUser(unm,passwd);
			String message="Welcome You Logged in Successfully";
			return new ModelAndView("hello","msg",message);
		}catch(EmptyResultDataAccessException e) {
			String message="invalid Username or password";
			return new ModelAndView("login","msg",message);
		}	
	
		
	}
}
