package com.lms.employee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Employee")
public class Employee {

	@Id
	private String id;
	private String name;
	private String contact;
	private String dateOfJoining;
	private String email;
	private String dateOfBirth;

	public Employee(String id, String name, String contact, String dateOfJoining, String email,
					String dateOfBirth) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public Employee(String name, String contact, String dateOfJoining, String email,
					String dateOfBirth) {
		this.name = name;
		this.contact = contact;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public Employee(){

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
