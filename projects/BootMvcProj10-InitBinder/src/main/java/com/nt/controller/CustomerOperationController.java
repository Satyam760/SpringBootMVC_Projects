package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;

@Controller
public class CustomerOperationController {
	
	@GetMapping("/")
	public  String showFormPage(@ModelAttribute("cust") Customer cust) {
		//return LVN
		return "customer_register_form";
	}
	
	@PostMapping("/register")
	public String processCustomeForm(@ModelAttribute("cust")Customer cust,Map<String,Object>map) {
		System.out.println("CustomerOperationController.processCustomeForm()");
		System.out.println("model obj data :: "+cust);
		map.put("custData", cust);
		return "show_result";
	}
	
	
	@InitBinder
	public void myDataBinder(WebDataBinder binder) {
		System.out.println("CustomerOperationController.myDataBinder()");
		
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
		
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf1,true));
	}
	
	
	
	
	
	
	
}
