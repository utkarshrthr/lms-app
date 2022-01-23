package com.lms.employee.request;

public class ReportRequest {

	private String behaviour;
	private String performance;
	private String communication;
	private String description;
	private String employeeId;

	public ReportRequest(String behaviour, String performance, String communication, String description,
				  String employeeId) {
		this.behaviour = behaviour;
		this.performance = performance;
		this.communication = communication;
		this.description = description;
		this.employeeId = employeeId;
	}

	public ReportRequest() {

	}

	public String getBehaviour() {
		return behaviour;
	}
	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
}
