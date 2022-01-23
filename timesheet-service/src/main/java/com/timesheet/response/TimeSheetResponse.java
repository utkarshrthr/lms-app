package com.timesheet.response;

/**
 * @author UtkarshRathore on 23-01-2022
 **/
public class TimeSheetResponse {

    private String id;
    private String workTime;
    private String weekDay;
    private String employeeId;

    public TimeSheetResponse(String id, String workTime, String weekDay, String employeeId) {
        this.id = id;
        this.workTime = workTime;
        this.weekDay = weekDay;
        this.employeeId = employeeId;
    }

    public TimeSheetResponse(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
