package com.reports.controller;

import java.util.List;

import com.reports.request.ReportRequest;
import com.reports.response.ReportListResponse;
import com.reports.response.ReportResponse;
import com.reports.services.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.reports.model.Report;

@RestController
@CrossOrigin("*")
@RequestMapping("/lms/reports/")
public class ReportController {

	@Autowired
	private ReportServiceImpl reportServiceImpl;

	@GetMapping
	public ReportListResponse getAllReport(){
		List<ReportResponse> responses = reportServiceImpl.getAllReport();
		return new ReportListResponse(responses);
	}

	@GetMapping("/employee/{id}")
	public ReportListResponse getReportByEmployeeId(@PathVariable("id") String employeeId) {
		List<ReportResponse> responses = reportServiceImpl.getReportByEmployeeId(employeeId);
		return new ReportListResponse(responses);
	}
	
	@GetMapping("/{id}")
	public ReportResponse getReportById(@PathVariable("id") String reportId) {
		return reportServiceImpl.getReport(reportId);
	}
	
	@PostMapping("/employee/all")
	public ReportListResponse addAllReport(@RequestBody List<ReportRequest> report) {
		return new ReportListResponse(reportServiceImpl.addAllReports(report));
	}

	@PostMapping
	public ReportResponse addReport(@RequestBody ReportRequest report) {
		return reportServiceImpl.addReport(report);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String reportId){
		reportServiceImpl.delete(reportId);
		return new ResponseEntity<>("Report deleted successfully", HttpStatus.OK);
	}
}
