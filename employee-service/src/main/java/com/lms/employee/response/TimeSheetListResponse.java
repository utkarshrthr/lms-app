package com.lms.employee.response;

import java.util.List;

/**
 * @author UtkarshRathore on 23-01-2022
 **/
public class TimeSheetListResponse {

    private List<TimeSheetResponse> timeSheets;

    public TimeSheetListResponse(){

    }

    public TimeSheetListResponse(List<TimeSheetResponse> timeSheets) {
        this.timeSheets = timeSheets;
    }

    public List<TimeSheetResponse> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<TimeSheetResponse> timeSheets) {
        this.timeSheets = timeSheets;
    }
}
