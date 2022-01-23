package com.timesheet.repository;

import com.timesheet.model.TimeSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;


@EnableMongoRepositories
public interface TimeSheetRepository extends MongoRepository<TimeSheet, String> {

	List<TimeSheet> findAllByEmployeeId(String employeeId);
}
