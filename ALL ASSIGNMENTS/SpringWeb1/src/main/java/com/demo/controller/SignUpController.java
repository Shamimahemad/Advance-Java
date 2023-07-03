package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.LoginService;

@Controller
@RequestMapping("/mysignup")
public class SignUpController {

	@Autowired
LoginService ls;

	@PostMapping("/signup")
	public ModelAndView createUser(HttpSession session ,@RequestParam("uname") String unm,@RequestParam String passwd) {
		boolean status=ls.createUser(unm,passwd);
		if(status) {
			String message="Your account created successfully..";
			return new ModelAndView("/login","msg",message);
		}else {
			String message="Your account not created";
			return new ModelAndView("signup","msg",message);
		}
	}
}
