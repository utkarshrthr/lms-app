package com.lms.employee.repository;

import com.lms.employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@EnableMongoRepositories
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
