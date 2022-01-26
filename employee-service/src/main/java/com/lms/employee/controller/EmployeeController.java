package com.lms.employee.controller;

import java.util.List;

import com.lms.employee.model.Employee;
import com.lms.employee.request.EmployeeRequest;
import com.lms.employee.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lms.employee.service.EmployeeServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/lms/employees")
@EnableCircuitBreaker
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping
	public List<EmployeeResponse> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public EmployeeResponse getEmployeeById(@PathVariable("id") String id) {
		return employeeService.getEmployee(id);
	}
	
	@PostMapping
	public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest request) {
		EmployeeResponse employee = employeeService.addEmployee(request);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") String employeeId){
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>("Employee data deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee , @PathVariable("id") String employeeId) {
		employeeService.updateEmployee(employee, employeeId);
		return new ResponseEntity<>("Employee data updated successfully", HttpStatus.OK);
	}
}
