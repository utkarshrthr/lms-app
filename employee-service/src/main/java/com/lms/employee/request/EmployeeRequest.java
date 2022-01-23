package com.lms.employee.request;

import java.util.List;

/**
 * @author UtkarshRathore on 22-01-2022
 **/
public class EmployeeRequest {

    private String name;
    private String contact;
    private String dateOfJoining;
    private String email;
    private String dateOfBirth;
    private List<ReportRequest> reports;
    private List<TimeSheetRequest> timeSheets;

    public EmployeeRequest(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<ReportRequest> getReports() {
        return reports;
    }

    public void setReports(List<ReportRequest> reports) {
        this.reports = reports;
    }

    public List<TimeSheetRequest> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<TimeSheetRequest> timeSheets) {
        this.timeSheets = timeSheets;
    }
}
