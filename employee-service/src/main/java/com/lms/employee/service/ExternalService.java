package com.lms.employee.service;

import com.lms.employee.request.ReportRequest;
import com.lms.employee.request.TimeSheetRequest;
import com.lms.employee.response.ReportResponse;
import com.lms.employee.response.TimeSheetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author UtkarshRathore on 22-01-2022
 **/
@Service
public interface ExternalService {
    List<ReportResponse> getReportsByEmployeeId(String employeeId);
    List<TimeSheetResponse> getTimeSheetsByEmployeeId(String employeeId);
    List<ReportResponse> addReportsForEmployee(List<ReportRequest> reports);
    List<TimeSheetResponse> addTimeSheetsForEmployee(List<TimeSheetRequest> timeSheets);
}
