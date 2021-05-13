package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	Employee get(int id);
	
	Employee save(Employee employee);
	
	void delete(int id); 
}
