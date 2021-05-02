package com.employee.data.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.data.api.exception.EmployeeNotFoundException;
import com.employee.data.api.model.Employee;
import com.employee.data.api.service.EmployeeService;

/**
 * RestController for accessing all the end-points
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * The getAllEmployee end-point return the list of all the employees
	 */
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}

	/**
	 * The saveEmployee end-point saves the incoming employee object to the database
	 */
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	/**
	 * The saveAllEmployee end-point saves the list of employees to the database
	 */
	@PostMapping("/saveAllEmployee")
	public ResponseEntity<Employee> saveAllEmployee(@RequestBody List<Employee> employee) {
		return employeeService.saveAllEmployee(employee);
	}

	/**
	 * The getEmployeeById end-point gets a single employee object based on the
	 * employee id passes
	 * 
	 * @throws EmployeeNotFoundException if the Employee ID is not found in database
	 */
	@GetMapping("/getEmployeeById/{eid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("eid") int id) throws EmployeeNotFoundException {
		return employeeService.getEmployeeById(id);
	}

	/**
	 * The updateEmployee end-point first finds the employee based on employee ID
	 * and then updates the existing employee record by the new incoming data
	 * 
	 * @throws EmployeeNotFoundException if the Employee ID is not found in database
	 */
	@PostMapping("/updateEmployee/{eid}")
	public ResponseEntity<Employee> updateEmployeeByID(@PathVariable("eid") int id,
			@RequestBody Employee employeeDetails) throws EmployeeNotFoundException {
		return employeeService.updateEmployeeByID(id, employeeDetails);
	}

	/**
	 * The deleteEmployeeById end-point first finds the employee based on employee
	 * ID and then deletes the existing employee record from the database
	 * 
	 * @throws EmployeeNotFoundException if the Employee ID is not found in database
	 */
	@GetMapping("/deleteEmployeeById/{eid}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("eid") int id) throws EmployeeNotFoundException {
		return employeeService.deleteEmployeeById(id);
	}

	/**
	 * The deleteAllEmployee end-point deletes all the employee record's from the
	 * database
	 */
	@GetMapping("/deleteAllEmployee")
	public ResponseEntity<Employee> deleteAllEmployee() {
		return employeeService.deleteAllEmployee();
	}
}
