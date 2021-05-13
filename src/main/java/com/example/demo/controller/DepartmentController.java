package com.example.demo.controller;

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

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	DepartmentService deptservice;
	
	
	@GetMapping("/department")
	public List<Department> get(){
		return deptservice.get();
	}
	

	@PostMapping("/department")
	public Department
	save(@RequestBody Department departmentObj) {
		deptservice.save(departmentObj);
		
		return departmentObj;
		
	}
	

	
	@GetMapping("/department/{id}")
	public Department get(@PathVariable int id) {
		Department departmentObj= deptservice.get(id);
		if(departmentObj == null) {
			throw new RuntimeException("Employee not found for the Id:"+id);
		}
		return departmentObj;
	}
	
	@PutMapping("/department")
	public Department update(@RequestBody Department departmentObj) {
		deptservice.save(departmentObj);
		return departmentObj;
	}
	
	@DeleteMapping("/department/{id}")
	public String delete(@PathVariable int id) {
		deptservice.delete(id);
		return "Employee has been deleted with id:"+id;
	}
}
