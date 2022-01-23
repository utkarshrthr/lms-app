package com.lms.employee.response;

import java.util.List;

/**
 * @author UtkarshRathore on 23-01-2022
 **/
public class EmployeeListResponse {

    private List<EmployeeResponse> employees;

    public List<EmployeeResponse> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeResponse> employees) {
        this.employees = employees;
    }
}
