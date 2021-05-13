package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {
	
	@Autowired
	EmployeeServiceImpl eemployeeserviceimpl;
	
	@MockBean
	EmployeeDAO employeeDAO; 
	
	@Test
	public void getTest() {
		Employee emp1=new Employee();
		Employee emp2=new Employee();
		
		emp1.setEmployeeid(1);
		emp1.setName("Akash");
		emp1.setGender("male");
		emp1.setDepartment("Support");
		emp1.setDob("12-05-2020");
	
		emp2.setEmployeeid(2);
		emp2.setName("Sam");
		emp2.setGender("male");
		emp2.setDepartment("Management");
		emp2.setDob("12-05-2020");
	List<Employee> list=new ArrayList<Employee>(); 
	list.add(emp1);
	list.add(emp2);
	Mockito.when(employeeDAO.get()).thenReturn(list);

	assertThat(eemployeeserviceimpl.get()).isEqualTo(list);
	}
	
	@Test
	public void saveTest() {
Employee emp1=new Employee();
		
		emp1.setEmployeeid(1);
		emp1.setName("Akash");
		emp1.setGender("male");
		emp1.setDepartment("Support");
		emp1.setDob("12-05-2020");
		Mockito.when(employeeDAO.save(emp1)).thenReturn(emp1);
		assertThat(eemployeeserviceimpl.save(emp1)).isEqualTo(emp1);
		
	}
    @Test
	public void getById() {
    	Employee emp1=new Employee();
    	emp1.setEmployeeid(1);
		emp1.setName("Akash");
		emp1.setGender("male");
		emp1.setDepartment("Support");
		emp1.setDob("12-05-2020");
		Mockito.when(employeeDAO.get(1)).thenReturn(emp1);
		assertThat(eemployeeserviceimpl.get(1)).isEqualTo(emp1);
	}


}
