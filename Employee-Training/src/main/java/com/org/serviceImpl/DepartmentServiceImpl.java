package com.org.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Department;
import com.org.repository.DepartmentRepository;
import com.org.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getDepartment() {
		return departmentRepository.findAll();
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department editDepartment(Department department, int departmentId) throws ResourceNotFoundException {
	
		Department department1 = 
			departmentRepository.findById(departmentId).orElseThrow( () -> 
	new ResourceNotFoundException("Department Id is not found " + departmentId));
			
		department1 = departmentRepository.saveAndFlush(department);
		return department1;
	//	return departmentRepository.saveAndFlush(department);
	
		}

	@Override
	public void deleteDepartment(int departmentId) throws ResourceNotFoundException {
		
		Department department = 
				departmentRepository.findById(departmentId).orElseThrow( () -> 
		new ResourceNotFoundException("Department Id is not found " + departmentId));
		
		// System.out.println(department);
		
		 departmentRepository.deleteById(departmentId);
		
	}

	
}