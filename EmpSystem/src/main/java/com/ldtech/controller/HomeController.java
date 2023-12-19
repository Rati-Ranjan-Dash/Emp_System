package com.ldtech.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ldtech.entity.Employee;
import com.ldtech.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String index(Model m) {
		
		List<Employee> list = employeeService.getAllEmp();
		m.addAttribute("empList", list);
		return "index";
	}
	
	@GetMapping("/empSave")
	public String empSave() {
		
		return "emp_save";
	}
	
	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable int id, Model m)
	{
		Employee emp=employeeService.getEmployeeById(id);
		m.addAttribute("emp",emp);
		return "edit_emp";
	}
	  
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp, HttpSession session) {
		
		Employee newEmp = employeeService.saveEmp(emp);
		//return "emp_save";
		// Httpsesion is an interface
		//msg is the name of the session
		if(newEmp!=null)
		{
			session.setAttribute("msg", "Register successfully");
		}
		else
		{
			session.setAttribute("msg", "Something wrong on server");
		}
		
		return "redirect:/empSave";
		
	}
	
	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session)
	{
		Employee updateEmp=employeeService.saveEmp(emp);
		if(updateEmp!=null)
		{
			session.setAttribute("msg","Update successfully");
		}
		else
		{
			session.setAttribute("msg","something wrong on server");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmployeeRecord(@PathVariable int id, HttpSession session)
	{
		boolean f=employeeService.deleteEmp(id);
		if(f)
		{
			session.setAttribute("msg", "delete successfully");
		}
		else
		{
			session.setAttribute("msg", "something wrong on server");
		}
		return "redirect:/";
	}
 
}
	
	

