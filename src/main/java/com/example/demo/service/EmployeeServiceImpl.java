package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.exception.businessException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Transactional
	@Override
	public List<Employee> get() {
		try {
		return employeeDAO.get();
		}
		catch(businessException e){
			throw new businessException(e.getErrorId(),e.getErrorMessage());
				}
	}

	@Transactional
	@Override
	public Employee get(int id) {
		
		try {
			return employeeDAO.get(id);
			}
			catch(businessException e){
				throw new businessException(e.getErrorId(),e.getErrorMessage());
					}
		}
	

	@Transactional
	@Override
	public Employee save(Employee employee) {
		
		try {
			return employeeDAO.save(employee);  
			}
			catch(businessException e){
				throw new businessException(e.getErrorId(),e.getErrorMessage());
					}
	}

	@Transactional
	@Override
	public void delete(int id) {
		
		try {
			employeeDAO.delete(id);
			}
			catch(businessException e){
				throw new businessException(e.getErrorId(),e.getErrorMessage());
					}
	}

}
