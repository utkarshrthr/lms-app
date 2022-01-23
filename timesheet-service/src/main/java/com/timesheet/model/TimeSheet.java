package com.timesheet.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TimeSheet")
public class TimeSheet {

	@Id
	private String id;
	private String workTime;
	private String weekDay;
	private String employeeId;

	public TimeSheet(String workTime, String weekDay, String employeeId) {
		this.workTime = workTime;
		this.weekDay = weekDay;
		this.employeeId = employeeId;
	}

	public TimeSheet(){

	}

	public String getEmployeeId() {
		return employeeId;
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

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
