package com.timesheet.controller;

import com.timesheet.request.TimeSheetRequest;
import com.timesheet.response.TimeSheetListResponse;
import com.timesheet.response.TimeSheetResponse;
import com.timesheet.sevice.TimeSheetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author UtkarshRathore on 23-01-2022
 **/ 

@RestController
@CrossOrigin("*")
@RequestMapping("/lms/timeSheets/")
public class TimeSheetsController {

    @Autowired
    private TimeSheetServiceImpl timeSheetServiceImpl;

    @GetMapping
    public TimeSheetListResponse getAllTimeSheet(){
        List<TimeSheetResponse> responses = timeSheetServiceImpl.getAllTimeSheet();
        return new TimeSheetListResponse(responses);
    }

    @GetMapping("/employee/{id}")
    public TimeSheetListResponse getTimeSheetByEmployeeId(@PathVariable("id") String employeeId) {
        List<TimeSheetResponse> responses = timeSheetServiceImpl.getTimeSheetByEmployeeId(employeeId);
        return new TimeSheetListResponse(responses);
    }

    @GetMapping("/{id}")
    public TimeSheetResponse getTimeSheetById(@PathVariable("id") String timeSheetId) {
        return timeSheetServiceImpl.getTimeSheet(timeSheetId);
    }

    @PostMapping
    public TimeSheetResponse addTimeSheet(@RequestBody TimeSheetRequest timeSheet) {
        return timeSheetServiceImpl.addTimeSheet(timeSheet);
    }

    @PostMapping("/employee/all")
    public TimeSheetListResponse addAllReport(@RequestBody List<TimeSheetRequest> requests) {
        return new TimeSheetListResponse(timeSheetServiceImpl.addAllTimeSheets(requests));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String timeSheetId){
        timeSheetServiceImpl.delete(timeSheetId);
        return new ResponseEntity<>("TimeSheet deleted successfully", HttpStatus.OK);
    }
}

