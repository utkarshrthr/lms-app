package com.lms.employee.service;

import com.lms.employee.request.ReportRequest;
import com.lms.employee.request.TimeSheetRequest;
import com.lms.employee.response.ReportListResponse;
import com.lms.employee.response.ReportResponse;
import com.lms.employee.response.TimeSheetListResponse;
import com.lms.employee.response.TimeSheetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author UtkarshRathore on 22-01-2022
 **/
@Service
public class ExternalServiceImpl implements ExternalService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.urls.service.timeSheet}")
    private String timeSheetServiceUrl;

    @Value("${app.urls.service.report}")
    private String reportsServiceUrl;

    @Override
    public List<ReportResponse> getReportsByEmployeeId(String employeeId) {
        ResponseEntity<ReportListResponse> reports = restTemplate.getForEntity(reportsServiceUrl+"/"+employeeId, ReportListResponse.class);
        return reports.getBody().getReports();
    }

    @Override
    public List<TimeSheetResponse> getTimeSheetsByEmployeeId(String employeeId) {
        ResponseEntity<TimeSheetListResponse> timeSheetListResponse = restTemplate.getForEntity(timeSheetServiceUrl+"/"+employeeId, TimeSheetListResponse.class);
        return timeSheetListResponse.getBody().getTimeSheets();
    }

    @Override
    public List<ReportResponse> addReportsForEmployee(List<ReportRequest> reports) {
        ReportListResponse reportList =
                restTemplate.postForObject(reportsServiceUrl+"/all", reports, ReportListResponse.class);
        return reportList.getReports();
    }

    @Override
    public List<TimeSheetResponse> addTimeSheetsForEmployee(List<TimeSheetRequest> timeSheets) {
        TimeSheetListResponse timeSheetList =
                restTemplate.postForObject(timeSheetServiceUrl+"/all", timeSheets, TimeSheetListResponse.class);
        return timeSheetList.getTimeSheets();
    }
}
