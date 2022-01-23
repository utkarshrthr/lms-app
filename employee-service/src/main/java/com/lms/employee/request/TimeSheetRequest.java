package com.lms.employee.request;

/**
 * @author UtkarshRathore on 22-01-2022
 **/

public class TimeSheetRequest {

    private String workTime;
    private String weekDay;
    private String employeeId;

    public TimeSheetRequest(String employeeId, String workTime, String weekDay) {
        this.employeeId = employeeId;
        this.workTime = workTime;
        this.weekDay = weekDay;
    }

    public TimeSheetRequest(){

    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
