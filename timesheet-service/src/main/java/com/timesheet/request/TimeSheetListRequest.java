package com.timesheet.request;

import java.util.List;

/**
 * @author UtkarshRathore on 23-01-2022
 **/
public class TimeSheetListRequest {

    private List<TimeSheetRequest> timeSheets;

    public TimeSheetListRequest(List<TimeSheetRequest> timeSheets) {
        this.timeSheets = timeSheets;
    }

    public List<TimeSheetRequest> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<TimeSheetRequest> timeSheets) {
        this.timeSheets = timeSheets;
    }
}
