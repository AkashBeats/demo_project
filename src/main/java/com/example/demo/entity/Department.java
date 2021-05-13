package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_department")
public class Department {
	

	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer department_id;
	
	@Column
	private String department;
	
	@OneToMany
//	@OneToMany(cascade = CascadeType.ALL)  
//	@JoinColumn(name="qid")  
//	@OrderColumn(name="type")  
	private List <Employee> ListEmp;

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Employee> getListEmp() {
		return ListEmp;
	}

	public void setListEmp(List<Employee> listEmp) {
		ListEmp = listEmp;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department=" + department + ", ListEmp=" + ListEmp
				+ "]";
	}

}
