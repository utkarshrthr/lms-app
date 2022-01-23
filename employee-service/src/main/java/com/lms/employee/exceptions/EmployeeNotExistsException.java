package com.lms.employee.exceptions;

/**
 * @author UtkarshRathore on 22-01-2022
 **/
public class EmployeeNotExistsException extends RuntimeException {
    public EmployeeNotExistsException(String message){
        super(message);
    }
}
