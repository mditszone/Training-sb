package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Employee;
import com.org.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// public String final GETEmployee = "/getEmployee";

	@GetMapping("/getEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.getEmployee();
	}

	@PostMapping("/saveEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/edit/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) 
			throws ResourceNotFoundException {
		return employeeService.editEmployee(employee, id);
	}

	  @GetMapping("/getEmployee/{id}") 
		public Employee getEmployeeID(@PathVariable int id) throws ResourceNotFoundException{
		  return employeeService.getEmployeeById(id);
		  }
		 
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) throws ResourceNotFoundException {

		employeeService.deleteEmployee(id); // delete the employee

		return "Employee Id is Deleted " + id;

	}

}
