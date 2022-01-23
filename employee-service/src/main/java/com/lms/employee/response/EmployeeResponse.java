package com.lms.employee.response;

import java.util.List;

/**
 * @author UtkarshRathore on 22-01-2022
 **/
public class EmployeeResponse {

    private String id;
    private String name;
    private String contact;
    private String dateOfJoining;
    private String email;
    private String dateOfBirth;
    private List<ReportResponse> reports;
    private List<TimeSheetResponse> timeSheets;

    public EmployeeResponse(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<ReportResponse> getReports() {
        return reports;
    }

    public void setReports(List<ReportResponse> reports) {
        this.reports = reports;
    }

    public List<TimeSheetResponse> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<TimeSheetResponse> timeSheets) {
        this.timeSheets = timeSheets;
    }
}
