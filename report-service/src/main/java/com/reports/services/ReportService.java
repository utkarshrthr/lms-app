package com.reports.services;

import com.reports.model.Report;
import com.reports.request.ReportRequest;
import com.reports.response.ReportResponse;

import java.util.List;

/**
 * @author UtkarshRathore on 22-01-2022
 **/
public interface ReportService {

    List<ReportResponse> getAllReport();
    List<ReportResponse> addAllReports(List<ReportRequest> requests);
    List<ReportResponse> getReportByEmployeeId(String employeeId);
    ReportResponse getReport(String reportId);
    ReportResponse addReport(ReportRequest report);
    void delete(String reportId);
}
