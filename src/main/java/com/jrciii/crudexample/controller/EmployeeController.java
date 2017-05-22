package com.jrciii.crudexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrciii.crudexample.domain.Employee;
import com.jrciii.crudexample.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
		Employee employee = employeeRepository.findOne(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee updatedEmployee,
			@PathVariable("id") String id) {
		Employee employee = employeeRepository.findOne(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		BeanUtils.copyProperties(updatedEmployee, employee);
		employee.setId(id);
		updatedEmployee = employeeRepository.save(employee);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") String id) {
		employeeRepository.delete(id);
	}
}
