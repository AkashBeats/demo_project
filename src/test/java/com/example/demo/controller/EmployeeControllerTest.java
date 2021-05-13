package com.example.demo.controller;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
    ObjectMapper Obj ;

	
	@MockBean
	EmployeeServiceImpl employeeserviceimpl;
	
	@Autowired
	private MockMvc mockMvc;
	
    @Test
	public void saveTest() throws Exception {
    	Employee emp1=new Employee();
	
		emp1.setEmployeeid(1);
		emp1.setName("Akash");
		emp1.setGender("male");
		emp1.setDepartment("Support");
		emp1.setDob("12-05-2020");
	
			String inputInJson = this.mapToJson(emp1);
		
		Mockito.when(employeeserviceimpl.save(Mockito.any(Employee.class))).thenReturn(emp1);
		String URI="/emp/employee";
		RequestBuilder requestBuilder= MockMvcRequestBuilders.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
    @Test
    public void getTest () throws Exception
    {
    	Employee emp1=new Employee();
    	
		emp1.setEmployeeid(1);
		emp1.setName("Akash");
		emp1.setGender("male");
		emp1.setDepartment("Support");
		emp1.setDob("12-05-2020");
	
		String InputJson=this.mapToJson(emp1);
		String URI="/emp/employee/1";
		Mockito.when(employeeserviceimpl.get(Mockito.anyInt())).thenReturn(emp1);
		
	RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
	
	MvcResult result=mockMvc.perform(requestBuilder).andReturn();
	MockHttpServletResponse response =result.getResponse();
	String outJson=response.getContentAsString();
	assertThat(outJson).isEqualTo(InputJson);
	assertEquals(HttpStatus.CREATED.value(),response.getStatus());
	

		
    	
    }
    
    @Test
    public void getAllTest() throws Exception {
	Employee emp2=new Employee();
	Employee emp1=new Employee();
		
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
	
	String inputJson=this.mapToJson(list);
	  	String URI="/emp/employee";
	  	Mockito.when(employeeserviceimpl.get()).thenReturn(list);
	  	
	  	RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
	  	
	MvcResult result=mockMvc.perform(requestBuilder).andReturn();
	MockHttpServletResponse response=result.getResponse();
	String outJson=response.getContentAsString();
	assertThat(outJson).isEqualTo(inputJson);
	
	
    }
   
    private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}