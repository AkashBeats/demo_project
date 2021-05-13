package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Department;

public interface DepartmentDAO {
	
	List<Department> get();
	
	Department get(int id);
	
	void save(Department department);
	
	void delete(int id);

}
