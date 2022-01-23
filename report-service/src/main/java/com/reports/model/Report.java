package com.reports.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Report")
public class Report {
	
	@Id
	private String id;
	private String behaviour;
	private String performance;
	private String communication;
	private String description;
	private String employeeId;
	
	public Report(String id, String behaviour, String performance, String communication, String description,
				  String employeeId) {
		this.id = id;
		this.behaviour = behaviour;
		this.performance = performance;
		this.communication = communication;
		this.description = description;
		this.employeeId = employeeId;
	}
	
	public Report() {
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
