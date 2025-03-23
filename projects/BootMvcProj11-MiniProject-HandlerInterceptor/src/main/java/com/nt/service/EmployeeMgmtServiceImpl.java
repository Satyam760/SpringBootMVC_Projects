package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		return "employee saved with id value :: "+empRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByNo(Integer eno) {
		Employee emp=empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		
		return "Employee is updated with id value :: "+empRepo.save(emp).getEmpno();
	}

	@Override
	public String deleteEmployeeById(Integer id) {
		empRepo.deleteById(id);
		
		return id+" Employee Id is deleted";
	}
	
	

}
