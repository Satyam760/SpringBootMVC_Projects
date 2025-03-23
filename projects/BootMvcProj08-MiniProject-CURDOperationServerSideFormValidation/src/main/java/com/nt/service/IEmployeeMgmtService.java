package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> getAllEmployee();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(Integer eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(Integer id);
	public   boolean  isDesgInRejectList(String desg);
}
