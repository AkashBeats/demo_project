package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DepartmentDAO;
import com.example.demo.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO; 
	
	@Transactional
	@Override
	public List<Department> get() {
		return departmentDAO.get();
	}

	@Transactional
	@Override
	public Department get(int id) {
		return departmentDAO.get(id);
	}


	@Override
	@Transactional
	public void save(Department department) {
		departmentDAO.save(department);
	}

	@Transactional
	@Override
	public void delete(int id) {
		departmentDAO.delete(id);
	}

}
