package com.lms.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lms.employee.exceptions.EmployeeNotExistsException;
import com.lms.employee.model.Employee;
import com.lms.employee.request.ReportRequest;
import com.lms.employee.repository.EmployeeRepository;
import com.lms.employee.request.EmployeeRequest;
import com.lms.employee.request.TimeSheetRequest;
import com.lms.employee.response.EmployeeResponse;
import com.lms.employee.response.ReportResponse;
import com.lms.employee.response.TimeSheetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;

	@Autowired
	private ExternalService externalService;

	@Override
	public List<EmployeeResponse> getAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		if(employees.isEmpty())
			return new ArrayList<>();
		List<EmployeeResponse> responses = new ArrayList<>();
		for(Employee employee:employees){
			String employeeId =  employee.getId();
			List<ReportResponse> reports= externalService.getReportsByEmployeeId(employeeId);
			List<TimeSheetResponse>  timeSheets = externalService.getTimeSheetsByEmployeeId(employeeId);
			EmployeeResponse response = getEmployeeResponseFromEmployee(employee, timeSheets, reports);
			responses.add(response);
		}
		return responses;
	}

	@Override
	public EmployeeResponse getEmployee(String employeeId) {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if(optional.isEmpty())
			throw new EmployeeNotExistsException(employeeId);
		Employee employee = optional.get();
		List<ReportResponse> reports= externalService.getReportsByEmployeeId(employeeId);
		List<TimeSheetResponse> timeSheets = externalService.getTimeSheetsByEmployeeId(employeeId);
		return getEmployeeResponseFromEmployee(employee, timeSheets, reports);
	}

	@Override
	public EmployeeResponse addEmployee(EmployeeRequest request) {
		Employee employee = getEmployeeFromRequest(request);
		Employee newRecord = employeeRepository.save(employee);
		List<TimeSheetRequest> timeSheets = request.getTimeSheets();
		List<TimeSheetResponse> timeSheetResponses = null;
		if(timeSheets != null && !timeSheets.isEmpty()){
			timeSheets.forEach(t -> t.setEmployeeId(newRecord.getId()));
			timeSheetResponses = externalService.addTimeSheetsForEmployee(timeSheets);
		}
		List<ReportRequest> reports = request.getReports();
		List<ReportResponse> reportResponses = null;
		if(reports != null && !reports.isEmpty()) {
			reports.forEach(t -> t.setEmployeeId(newRecord.getId()));
			reportResponses = externalService.addReportsForEmployee(reports);
		}
		return getEmployeeResponseFromEmployee(employee, timeSheetResponses, reportResponses);
	}

	public void deleteEmployee(String employeeId){
		if(employeeRepository.existsById(employeeId))
			employeeRepository.deleteById(employeeId);
		throw new EmployeeNotExistsException(employeeId);
	}

	@Override
	public void updateEmployee(Employee updatedEmp, String employeeId) {
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isPresent()) {
			Employee employee = empOptional.get();
			employee.setDateOfBirth(updatedEmp.getDateOfBirth());
			employee.setDateOfJoining(updatedEmp.getDateOfJoining());
			employee.setEmail(updatedEmp.getEmail());
			employee.setName(updatedEmp.getName());
			employee.setContact(updatedEmp.getContact());
			employeeRepository.save(employee);
		}
		else throw new EmployeeNotExistsException(employeeId);
	}

	private Employee getEmployeeFromRequest(EmployeeRequest request){
		Employee employee = new Employee();
		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		employee.setContact(request.getContact());
		employee.setDateOfBirth(request.getDateOfBirth());
		employee.setDateOfJoining(request.getDateOfJoining());
		return employee;
	}


	private EmployeeResponse getEmployeeResponseFromEmployee(Employee employee, List<TimeSheetResponse> timeSheets,
													 List<ReportResponse> reports){
		EmployeeResponse response = new EmployeeResponse();
		response.setId(employee.getId());
		response.setName(employee.getName());
		response.setEmail(employee.getEmail());
		response.setContact(employee.getContact());
		response.setDateOfBirth(employee.getDateOfBirth());
		response.setDateOfJoining(employee.getDateOfJoining());
		response.setTimeSheets(timeSheets);
		response.setReports(reports);
		return response;
	}
}
