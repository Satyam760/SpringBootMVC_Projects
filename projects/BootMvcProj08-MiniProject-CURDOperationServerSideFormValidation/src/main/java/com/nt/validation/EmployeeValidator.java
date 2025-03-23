package com.nt.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {  //place here form validation logics
		// type cast to Model  class
	 Employee  emp=(Employee)target;
	// write  server side form validation logics
		    if(emp.getEname().equals("") || emp.getEname().length()==0)   //required rule
	    	   errors.rejectValue("ename", "emp.name.required");
		     else if(emp.getEname().length()<5 || emp.getEname().length()>15)  //length rule
		   	  errors.rejectValue("ename", "emp.name.length");
				      
		     if(emp.getJob().equals("") || emp.getJob().length()==0)   //required rule
				    	   errors.rejectValue("job", "emp.job.required");
				   else if(emp.getJob().length()<4 || emp.getJob().length()>10)  //length rule
		   	  errors.rejectValue("job", "emp.job.length");
	    if(!errors.hasFieldErrors("sal")) {      
			if(emp.getSal()==null)   //required rule
		   	   errors.rejectValue("sal", "emp.salary.required");
				   else if(emp.getSal()<5000 || emp.getSal()>200000) //range rule
				 	  errors.rejectValue("sal", "emp.salary.range");
		    }
		
	}

}
