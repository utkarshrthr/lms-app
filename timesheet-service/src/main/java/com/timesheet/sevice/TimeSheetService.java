package com.timesheet.sevice;

import com.timesheet.request.TimeSheetRequest;
import com.timesheet.response.TimeSheetResponse;

import java.util.List;

/**
 * @author UtkarshRathore on 23-01-2022
 **/
public interface TimeSheetService {

    List<TimeSheetResponse> getAllTimeSheet();
    List<TimeSheetResponse> getTimeSheetByEmployeeId(String employeeId);
    TimeSheetResponse getTimeSheet(String reportId);
    TimeSheetResponse addTimeSheet(TimeSheetRequest report);
    void delete(String reportId);
    List<TimeSheetResponse> addAllTimeSheets(List<TimeSheetRequest> addAllTimeSheets);
}
