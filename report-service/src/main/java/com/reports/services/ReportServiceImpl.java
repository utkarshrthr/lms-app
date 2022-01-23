package com.reports.services;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import com.reports.request.ReportRequest;
import com.reports.response.ReportResponse;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.reports.model.Report;
import com.reports.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository repository;

	@Override
	public List<ReportResponse> getReportByEmployeeId(String employeeId){
		List<Report> reports = repository.findAllByEmployeeId(employeeId);
		List<ReportResponse> responses = new ArrayList<>();
		for(Report report:reports){
			responses.add(getReportResponseFromReport(report));
		}
		return responses;
	}

	@Override
	public List<ReportResponse> getAllReport(){
		List<Report> reports = repository.findAll();
		List<ReportResponse> responses = new ArrayList<>();
		for(Report report:reports){
			responses.add(getReportResponseFromReport(report));
		}
		return responses;
	}

	@Override
	public List<ReportResponse> addAllReports(List<ReportRequest> requests) {
		List<Report> reports = new ArrayList<>();
		for(ReportRequest request:requests){
			reports.add(getReportFromReportRequest(request));
		}
		List<Report> newRecords = repository.saveAll(reports);
		List<ReportResponse> responses = new ArrayList<>();
		for (Report report: newRecords){
			responses.add(getReportResponseFromReport(report));
		}
		return responses;
	}

	@Override
	public ReportResponse getReport(String reportId) {
		Optional<Report> report = repository.findById(reportId);
		return getReportResponseFromReport(report.get());
	}

	@Override
	public ReportResponse addReport(ReportRequest request) {
		Report report = getReportFromReportRequest(request);
		return getReportResponseFromReport(report);
	}

	@Override
	public void delete(String reportId){
		repository.deleteById(reportId);
	}

	private Report getReportFromReportRequest(ReportRequest request){
		Report report = new Report();
		report.setBehaviour(request.getBehaviour());
		report.setCommunication(request.getCommunication());
		report.setDescription(request.getDescription());
		report.setEmployeeId(request.getEmployeeId());
		report.setPerformance(request.getPerformance());
		return report;
	}

	private ReportResponse getReportResponseFromReport(Report report){
		ReportResponse response = new ReportResponse();
		response.setId(report.getId());
		response.setBehaviour(report.getBehaviour());
		response.setCommunication(report.getCommunication());
		response.setDescription(report.getDescription());
		response.setEmployeeId(report.getEmployeeId());
		response.setPerformance(report.getPerformance());
		return response;
	}
}
