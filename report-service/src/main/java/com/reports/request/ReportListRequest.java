package com.reports.request;

import java.util.List;

/**
 * @author UtkarshRathore on 23-01-2022
 **/
public class ReportListRequest {

    private List<ReportRequest> reports;

    public List<ReportRequest> getReports() {
        return reports;
    }

    public void setReports(List<ReportRequest> reports) {
        this.reports = reports;
    }
}
