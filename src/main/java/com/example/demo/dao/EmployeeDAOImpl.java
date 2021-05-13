package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import com.example.demo.HibernateUtil;
import com.example.demo.entity.Employee;
import com.example.demo.exception.businessException;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list=null;
		
		try {
			 list = query.getResultList();
			
		}
		catch (Exception e) {
			throw new businessException(605,"Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
		if(list.isEmpty()) {
			throw new businessException(604, "Hey list completely empty, we have nothing to return");
		}

		return list;
	}

	@Override
	public Employee get(int id) {
		Session currentSession = HibernateUtil.getSessionFactory().openSession();
		currentSession.beginTransaction();
		
	
		try {
			Employee employeeObj = currentSession.get(Employee.class, id);
			return employeeObj;
			}
			catch (IllegalArgumentException e) {
				throw new businessException(602,"given employee is null" + e.getMessage());
			}catch (Exception e) {
				throw new businessException(603,"Something went wrong in Service layer while saving the employee" + e.getMessage());
			}

	}

	@Override
	public Employee save(Employee employee) {
//		Session currentSession = entityManager.unwrap(Session.class);
		Session currentSession = HibernateUtil.getSessionFactory().openSession();
		
		if(employee==null || employee.getName().length()==0) {
			throw new businessException(601,"Please make sure the bean alues are populated");
		}
		try {
		currentSession.saveOrUpdate(employee);
		return employee;
		}
		catch (IllegalArgumentException e) {
			throw new businessException(602,"given employee is null" + e.getMessage());
		}catch (Exception e) {
			throw new businessException(603,"Something went wrong in Service layer while saving the employee" + e.getMessage());
		}

		
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		
		try {
	
		currentSession.delete(employeeObj);
		}
		catch (IllegalArgumentException e) {
			throw new businessException(602,"given employee is null" + e.getMessage());
		}catch (Exception e) {
			throw new businessException(603,"Something went wrong in Service layer while saving the employee" + e.getMessage());
		}
	}

//	@Override
//	public Employee get(int id) {
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//	
//		try {
//			Employee employeeObj = currentSession.get(Employee.class, id);
//			return employeeObj;
//			}
//			catch (IllegalArgumentException e) {
//				throw new businessException(602,"given employee is null" + e.getMessage());
//			}catch (Exception e) {
//				throw new businessException(603,"Something went wrong in Service layer while saving the employee" + e.getMessage());
//			}
//
//	}

	
}
