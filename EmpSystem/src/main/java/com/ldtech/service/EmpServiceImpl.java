package com.ldtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.ldtech.entity.Employee;
import com.ldtech.repository.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee saveEmp(Employee emp) {
		
		Employee newEmp = repository.save(emp);
		return newEmp;
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {

		return repository.findById(id).get();
		//
	}

	@Override
	public boolean deleteEmp(int id) {

		Employee emp = repository.findById(id).get();
		if(emp!=null)
		{
			repository.delete(emp);
			return true;
		}
		return false;
	}
	
	public void removeSessionMessage() {
		
		//when getRequestAttributes() is invoked by RequestContextHolder interface
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
		
	}
	
	
	
	
}
