package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validation.EmployeeValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeMgmtService service;
	@Autowired
	private EmployeeValidator empValidator;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/emp_add")//form lunching
	public String showFormSaveEmployee(@ModelAttribute("emp") Employee emp) {
		//return LVN
		return "register_emp";
	}
	
	/*//for submission duplicate recored will be registered    for this we use 
	@PostMapping("/emp_add")
	public String saveEmployee(Map<String,Object>map,@ModelAttribute("emp") Employee emp) {
		//use service
		String msg=service.registerEmployee(emp);
		List<Employee>list=service.getAllEmployee();
		//keep in model attribute 
		map.put("resultMsg", msg);
		map.put("result", list);
		//return LVC
		return "show_employee_report";
	}*/
	
	//PRG Pattern
	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map) {
		//use service 
		List<Employee>list=service.getAllEmployee();
		//put into result  in model attribute
		map.put("result", list);
		//return LVN
		return "show_employee_report";
	}
	
	/*@PostMapping("/emp_add")  //here we can't get result msg after save emp 
	public String saveEmployee(Map<String,Object>map,@ModelAttribute("emp") Employee emp) {
		//use service
		String msg=service.registerEmployee(emp);
		//keep in model attribute
		map.put("resultMsg", msg);   
		//return LVC
		return "redirect:report"; //redirect to show_employee_report.jsp
	}*/
	
	/*@PostMapping("/emp_add")
	public String saveEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
		//use service
		String msg=service.registerEmployee(emp);
		//keep the result in flash attribute
		attrs.addFlashAttribute("resultMsg", msg);    
		//return LVC
		return "redirect:report"; //redirect to show_employee_report.jsp
	}*/
	
	
	@PostMapping("/emp_add")
	public String saveEmployee(HttpSession sec,@ModelAttribute("emp") Employee emp,BindingResult errors) {
		System.out.println("EmployeeOperationController.saveEmployee()");
		
		/*// enable  the server side form validations only when the client side form validations are not done
		  if(emp.getVflag().equalsIgnoreCase("no")) {
				//use the validator
				if(empValidator.supports(emp.getClass())) {
					 empValidator.validate(emp, errors);
					 if(errors.hasErrors()) {
						  return "register_emp";
					 }
				}
		  }*/
		// enable  the server side form validations only when the client side form validations are not done
		   if(emp.getVflag().equalsIgnoreCase("no")) {
				//use the validator
				if(empValidator.supports(emp.getClass())) {
					 empValidator.validate(emp, errors);
					 if(errors.hasErrors()) {
						  return "register_emp";
					 }
				}
		   }
				
				//application logic errors
				if(service.isDesgInRejectList(emp.getJob())) {
					errors.rejectValue("job", "emp.desg.reject");
					return "register_emp";
				}
		
		//use service
		String msg=service.registerEmployee(emp);
		//keep in model attribute
		sec.setAttribute("resultMsg", msg);    
		//return LVC
		return "redirect:report"; //redirect to show_employee_report.jsp
	}
	
	
	//update upration
	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no")Integer no,
			                               @ModelAttribute("emp")Employee emp) {
		//use service 
		Employee emp1=service.getEmployeeByNo(no);
		//copy data
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "update_employee";
		
	}
	
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp")Employee emp,BindingResult errors) {
		// enable  the server side form validations only when the client side form validations are not done
		  if(emp.getVflag().equalsIgnoreCase("no")) {
				//use the validator
				if(empValidator.supports(emp.getClass())) {
					 empValidator.validate(emp, errors);
					 if(errors.hasErrors()) {
						  return "update_employee";
					 }
				}
		  }
		//use service
		String msg=service.updateEmployee(emp);
		//add the result message ad flash attribute
		attrs.addFlashAttribute("resultMsg", msg);
		//redirect to the show employee report
		return "redirect:report";
		
	}
	
	//delete operation
	@GetMapping("emp_delete")
	public String deleteEmployee(RedirectAttributes attrs,@RequestParam Integer no) {
		//use servie
		String msg=service.deleteEmployeeById(no);
		//keep the resutl in flashAttribute
		attrs.addFlashAttribute("resultMsg", msg);
		//redirect the request
		return "redirect:report";
		
	}
	

}
