package com.org.service;

import java.util.List;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Department;

public interface DepartmentService {

	
	public List<Department> getDepartment();
	public Department saveDepartment(Department department);
	public Department editDepartment(Department department, int departmentId) throws ResourceNotFoundException;
	public void deleteDepartment(int id) throws ResourceNotFoundException;
	
}
