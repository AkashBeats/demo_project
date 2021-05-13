package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentService {
	
	List<Department> get();
	
	Department get(int id);
	
	void save(Department department);
	
	void delete(int id); 
}
