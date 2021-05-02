package com.employee.data.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.data.api.exception.EmployeeNotFoundException;
import com.employee.data.api.model.Employee;

@Service
public interface EmployeeService {

	List<Employee> findAll();

	Employee save(Employee employee);

	ResponseEntity<Employee> getEmployeeById(int id) throws EmployeeNotFoundException;

	ResponseEntity<Employee> updateEmployeeByID(int id, Employee employeeDetails) throws EmployeeNotFoundException;

	ResponseEntity<Employee> deleteEmployeeById(int id) throws EmployeeNotFoundException;

	ResponseEntity<Employee> saveAllEmployee(List<Employee> employee);

	ResponseEntity<Employee> deleteAllEmployee();

}
