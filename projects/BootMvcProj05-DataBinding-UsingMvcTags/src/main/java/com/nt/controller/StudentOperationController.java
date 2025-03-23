package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationController {
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/register")  // to lunch form page
	public String showStudentFormPage(@ModelAttribute("stud") Student st) {
		return "student_register";
	}
	
	@PostMapping("/register")//for form submission
	public String registerStudent(Map<String,Object>map,@ModelAttribute("stud") Student st) {
		System.out.println(st);
		String grade=null;
		if(st.getAvg()>=75)
			grade="First calss with Dist";
		else if(st.getAvg()>=60)
			grade="First calss ";
		else if(st.getAvg()>=35)
			grade="3rd calss ";
		else 
			grade="fail";
		
		map.put("result",grade);
		return "show_result";
	}
	

}
