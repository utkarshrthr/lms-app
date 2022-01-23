package com.reports.response;

import java.util.List;

/**
 * @author UtkarshRathore on 23-01-2022
 **/
public class ReportListResponse {

    private List<ReportResponse> reports;

    public List<ReportResponse> getReports() {
        return reports;
    }

    public void setReports(List<ReportResponse> reports) {
        this.reports = reports;
    }

    public ReportListResponse() {}

    public ReportListResponse(List<ReportResponse> reports) {
        this.reports = reports;
    }
}
