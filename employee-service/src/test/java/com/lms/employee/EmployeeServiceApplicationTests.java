package com.lms.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.lms.employee.model.Employee;
import com.lms.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceApplicationTests {

	@Autowired
    EmployeeRepository employeeRepository;
	
	@Test
	@Order(1)
	 void testCreate() {
		Employee emp =new Employee();
		emp.setEmail("deepak@gmail.com");
		emp.setId("1");
		emp.setDateOfJoining("10/11/22");
		emp.setDateOfJoining("20/07/1999");
		emp.setName("Deepak");
		emp.setContact("97588282762");
		employeeRepository.save(emp);
		assertNotNull(employeeRepository.findById("1").get());
	}

//	@Test
//	@Order(2)
//	 void testSingleEmployee() {
//		Employee emp = employeeRepository.findById("1").get();
//		assertEquals("Deepak", emp.getEmpName());
//	}
	
//	@Test
//	@Order(3)
//	 void updateEmp() {
//		Employee emp = employeeRepository.findById("1").get();
//		emp.setEmpName("Aman");
//		employeeRepository.save(emp);
//		assertNotEquals("Deepak", employeeRepository.findById("1").get().getEmpName());
//	}
	
//	@Test
//	@Order(4)
//	 void deleteEmp() {
//		employeeRepository.deleteById("1");
//		assertThrows(NullPointerException.class, isNull());
//		
//	}
}
