package com.lms.employee.service;

import com.lms.employee.model.Employee;
import com.lms.employee.request.EmployeeRequest;
import com.lms.employee.response.EmployeeResponse;

import java.util.List;

/**
 * @author UtkarshRathore on 22-01-2022
 **/
public interface EmployeeService {
    List<EmployeeResponse> getAllEmployee();
    EmployeeResponse getEmployee(String employeeId);
    EmployeeResponse addEmployee(EmployeeRequest request);
    void deleteEmployee(String employeeId);
    void updateEmployee(Employee employee, String employeeId);
}
