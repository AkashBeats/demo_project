package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import com.example.demo.HibernateUtil;
import com.example.demo.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Department> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Department> query = currentSession.createQuery("from Department", Department.class);
		List<Department> list = query.getResultList();
		return list;
	}

	@Override
	public Department get(int id) {
		//Session currentSession = entityManager.unwrap(Session.class);
		Session currentSession =HibernateUtil.getSessionFactory().openSession();
		currentSession.beginTransaction();
		
		Department departmentObj = currentSession.get(Department.class, id);
	
		return departmentObj;
	}

	@Override
	public void save(Department department) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(department);
		
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Department departmentObj = currentSession.get(Department.class, id);
		currentSession.delete(departmentObj);
	}
	

}
