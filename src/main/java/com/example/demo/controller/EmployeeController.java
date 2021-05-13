package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ControllerException;
import com.example.demo.exception.businessException;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<?>  save(@RequestBody Employee employeeObj) {
	
		try
		{
		Employee emp= employeeService.save(employeeObj);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		catch(businessException e) {
			ControllerException ce = new ControllerException(e.getErrorId(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	

		}
		catch (Exception e) {
			ControllerException ce = new ControllerException(612,"Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	
		
		
	}
	
	@GetMapping("/employee")
	public ResponseEntity<?> get(){
		
		try
		{
			List<Employee> emp=employeeService.get();
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.CREATED);
		}
		catch(businessException e) {
			ControllerException ce = new ControllerException(e.getErrorId(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	

		}
		catch (Exception e) {
			ControllerException ce = new ControllerException(612,"Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> get(@PathVariable int id) {
		
		try
		{
			Employee employeeObj = employeeService.get(id);
			if(employeeObj == null) {
				throw new RuntimeException("Employee not found for the Id:"+id);
			}
		return new ResponseEntity<Employee>(employeeObj,HttpStatus.CREATED);
		}
		catch(businessException e) {
			ControllerException ce = new ControllerException(e.getErrorId(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	

		}
		catch(RuntimeException e) {
			ControllerException ce=new ControllerException(605, e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			ControllerException ce = new ControllerException(612,"Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/employee")
	public ResponseEntity<?> update(@RequestBody Employee employeeObj) {
		
		try
		{
			Employee employee = employeeService.save(employeeObj);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		}
		catch(businessException e) {
			ControllerException ce = new ControllerException(e.getErrorId(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	

		}
		catch (Exception e) {
			ControllerException ce = new ControllerException(612,"Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		try
		{
			employeeService.delete(id);
		
		
		return new ResponseEntity<String>("Employee has been deleted with id:"+id,HttpStatus.CREATED);
		}
		catch(businessException e) {
			ControllerException ce = new ControllerException(e.getErrorId(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	

		}
		catch (Exception e) {
			ControllerException ce = new ControllerException(612,"Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
}
