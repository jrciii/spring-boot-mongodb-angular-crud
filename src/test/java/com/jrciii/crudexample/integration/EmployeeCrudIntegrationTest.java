package com.jrciii.crudexample.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrciii.crudexample.controller.EmployeeController;
import com.jrciii.crudexample.domain.Employee;
import com.jrciii.crudexample.domain.EmployeePositionCategory;
import com.jrciii.crudexample.domain.State;
import com.jrciii.crudexample.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
public class EmployeeCrudIntegrationTest {
    @Configuration
    @EnableAutoConfiguration
    @EnableMongoRepositories(basePackageClasses={EmployeeRepository.class})
    @ComponentScan(basePackageClasses={EmployeeController.class})
    @EnableWebMvc
    public static class Config {

    }
    
	@Autowired
	private WebApplicationContext wac;
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
    	this.mockMvc = webAppContextSetup(wac).build();
    }
	
	@Test
	public void testMongoIntegration() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = new Employee(null, "John", "Doe", "M", "test@test.com", "5555555555", EmployeePositionCategory.EXECUTIVE, new Date(), "123 Mystery Hut", "", "City", State.ALABAMA, 33333, true);
		
		//Post
		MvcResult result = mockMvc.perform(post("/api/employee").contentType("application/json").accept("application/json").content(mapper.writeValueAsString(employee))).andDo(print()).andExpect(status().isOk()).andReturn();
		Employee savedEmployee = mapper.readValue(result.getResponse().getContentAsString(),Employee.class);
		assertNotNull(savedEmployee.id);
		String id = savedEmployee.id;
		savedEmployee.id = null;
		assertEquals(employee,savedEmployee);
		
		// Put
		employee.addressTwo = "#2";
		result = mockMvc.perform(put("/api/employee/" + id).contentType("application/json").accept("application/json").content(mapper.writeValueAsString(employee))).andDo(print()).andExpect(status().isOk()).andReturn();
		savedEmployee = mapper.readValue(result.getResponse().getContentAsString(),Employee.class);
		assertNotNull(savedEmployee.id);
		assertEquals(id, savedEmployee.id);

		// Get all
		result = mockMvc.perform(get("/api/employee").contentType("application/json").accept("application/json").content(mapper.writeValueAsString(employee))).andDo(print()).andExpect(status().isOk()).andReturn();
		List<Employee> employees = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Employee>>(){});
		assertEquals(1,employees.size());
		assertEquals(savedEmployee,employees.get(0));
		
		// Get one
		result = mockMvc.perform(get("/api/employee/" + id)).andDo(print()).andExpect(status().isOk()).andReturn();
		Employee getEmployee = mapper.readValue(result.getResponse().getContentAsString(),Employee.class);
		assertEquals(savedEmployee,getEmployee);
		
		// Delete
		mockMvc.perform(delete("/api/employee/" + id)).andDo(print()).andExpect(status().isOk());
	
		// Verify delete with get one
		mockMvc.perform(get("/api/employee/" + id)).andDo(print()).andExpect(status().isNotFound());
	}
}
