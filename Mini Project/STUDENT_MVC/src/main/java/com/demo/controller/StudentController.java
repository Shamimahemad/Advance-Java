package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Student;
import com.demo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
     
	@Autowired
	  private StudentService studentService;
	
	@RequestMapping("/studentlist")
	 public ModelAndView getAll() {
		List<Student> slist=studentService.getAll();
		return new ModelAndView("studentlist","slist",slist);
	}
	@RequestMapping("/studentform")
	 public String toStudentForm() {
		
		return "studentform";
	}
	
	@PostMapping("/addnewstudent")
	public ModelAndView addStudent(HttpSession session , @RequestParam int sid,@RequestParam String sname,@RequestParam String course,@RequestParam int marks,@RequestParam int year) {
		
		boolean status=studentService.addNewStudent(sid,sname,course,marks,year);
		if(status) {
			return new ModelAndView("redirect:/student/studentlist","msg","registered");
		}
		else {
			return new ModelAndView("redirect:/student/studentlist","msg","registeration failed");
		}
		
	}
	@GetMapping("/edit/{sid}")
	 public ModelAndView editStudentdetails(@PathVariable("sid") int sid) {
		Student s=studentService.getById(sid);
		System.out.println("Studetn data\n"+s);
		if(s!=null) {
			return new ModelAndView("editstudent","s",s);
		}
		return null;
	}
	
	@PostMapping("/updatestudent")
     public ModelAndView updateStudent(HttpSession session , @RequestParam int sid,@RequestParam String sname,@RequestParam String course,@RequestParam int marks,@RequestParam int year) {
		System.out.println("in update method"+sid+" "+sname+course+marks+year);
		boolean status=studentService.updateStudent(sid,sname,course,marks,year);
		if(status) {
			return new ModelAndView("redirect:/student/studentlist","msg","updated");
		}
		else {
			return new ModelAndView("redirect:/student/studentlist","msg","Updation failed");
		}
		
		
	}
	@GetMapping("/delete/{sid}")
	 public ModelAndView deleteStudent(@PathVariable("sid") int sid) {
		boolean status=studentService.delById(sid);
		
		if(status) {
			return new ModelAndView("redirect:/student/studentlist","msg","deleted");
		}
		return null;
	}
}
