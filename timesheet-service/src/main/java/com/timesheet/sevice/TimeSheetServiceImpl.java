package com.timesheet.sevice;

import com.timesheet.model.TimeSheet;
import com.timesheet.repository.TimeSheetRepository;
import com.timesheet.request.TimeSheetRequest;
import com.timesheet.response.TimeSheetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author UtkarshRathore on 23-01-2022
 **/
@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    @Autowired
    private TimeSheetRepository repository;

    @Override
    public List<TimeSheetResponse> getAllTimeSheet() {
        List<TimeSheet> timeSheets = repository.findAll();
        List<TimeSheetResponse> responses = new ArrayList<>();
        for(TimeSheet timeSheet:timeSheets){
            responses.add(getTimeSheetResponseFromTimeSheet(timeSheet));
        }
        return responses;
    }

    @Override
    public List<TimeSheetResponse> getTimeSheetByEmployeeId(String employeeId) {
        List<TimeSheet> timeSheets = repository.findAllByEmployeeId(employeeId);
        List<TimeSheetResponse> responses = new ArrayList<>();
        for(TimeSheet timeSheet:timeSheets){
            responses.add(getTimeSheetResponseFromTimeSheet(timeSheet));
        }
        return responses;
    }

    @Override
    public TimeSheetResponse getTimeSheet(String timeSheetId) {
        Optional<TimeSheet> timeSheet = repository.findById(timeSheetId);
        return getTimeSheetResponseFromTimeSheet(timeSheet.get());
    }

    @Override
    public TimeSheetResponse addTimeSheet(TimeSheetRequest request) {
        TimeSheet timeSheet = getTimeSheetFromTimeSheetRequest(request);
        return getTimeSheetResponseFromTimeSheet(timeSheet);
    }

    @Override
    public void delete(String timeSheetId) {
        repository.deleteById(timeSheetId);
    }

    @Override
    public List<TimeSheetResponse> addAllTimeSheets(List<TimeSheetRequest> requests) {
        List<TimeSheet> timeSheets = new ArrayList<>();
        for(TimeSheetRequest request:requests){
            timeSheets.add(getTimeSheetFromTimeSheetRequest(request));
        }
        List<TimeSheet> newRecords = repository.saveAll(timeSheets);
        List<TimeSheetResponse> responses = new ArrayList<>();
        for (TimeSheet timeSheet: newRecords){
            responses.add(getTimeSheetResponseFromTimeSheet(timeSheet));
        }
        return responses;
    }

    private TimeSheet getTimeSheetFromTimeSheetRequest(TimeSheetRequest request){
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setWeekDay(request.getWeekDay());
        timeSheet.setWorkTime(request.getWorkTime());
        timeSheet.setEmployeeId(request.getEmployeeId());
        return timeSheet;
    }

    private TimeSheetResponse getTimeSheetResponseFromTimeSheet(TimeSheet timeSheet){
        TimeSheetResponse response = new TimeSheetResponse();
        response.setId(timeSheet.getId());
        response.setWeekDay(timeSheet.getWeekDay());
        response.setWorkTime(timeSheet.getWorkTime());
        response.setEmployeeId(timeSheet.getEmployeeId());
        return response;
    }
}
