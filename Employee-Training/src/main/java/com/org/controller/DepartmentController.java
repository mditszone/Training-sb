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
import com.org.model.Department;
import com.org.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// public String final GETDepartment = "/getDepartment";

	@GetMapping("/getDepartment")
	public List<Department> getAllDepartment() {
		return departmentService.getDepartment();
	}

	@PostMapping("/saveDepartment")
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@PutMapping("/edit/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable int id) throws ResourceNotFoundException {

		return departmentService.editDepartment(department, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable int id) throws ResourceNotFoundException {

		departmentService.deleteDepartment(id); // delete the department

		return "Department Id is Deleted " + id;

	}
	
}
