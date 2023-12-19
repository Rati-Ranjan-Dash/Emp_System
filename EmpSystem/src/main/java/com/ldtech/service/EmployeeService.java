package com.ldtech.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ldtech.entity.Employee;

@Service
public interface EmployeeService {
	
	public Employee saveEmp(Employee emp);
	public List<Employee> getAllEmp();
	public Employee getEmployeeById(int id);
	public boolean deleteEmp(int id);
		
	
}
