package com.reports.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.reports.model.Report;

@EnableMongoRepositories
public interface ReportRepository extends MongoRepository<Report, String> {
	List<Report> findAllByEmployeeId(String employeeId);
}
