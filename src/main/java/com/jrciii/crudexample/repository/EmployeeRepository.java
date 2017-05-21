package com.jrciii.crudexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jrciii.crudexample.domain.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
