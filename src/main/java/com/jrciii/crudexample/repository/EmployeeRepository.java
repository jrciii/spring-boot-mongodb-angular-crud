package com.jrciii.crudexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jrciii.crudexample.domain.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
