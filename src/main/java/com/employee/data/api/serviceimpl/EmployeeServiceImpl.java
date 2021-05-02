package com.employee.data.api.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.employee.data.api.exception.EmployeeNotFoundException;
import com.employee.data.api.model.Employee;
import com.employee.data.api.repository.EmployeeRepository;
import com.employee.data.api.service.EmployeeService;

@Repository
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(int id) throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this Id"));
		return ResponseEntity.ok().body(employee);
	}

	@Override
	public ResponseEntity<Employee> updateEmployeeByID(int id, Employee employeeDetails)
			throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this Id"));
		employee.setFirst_name(employeeDetails.getFirst_name());
		employee.setLast_name(employeeDetails.getLast_name());
		employee.setEmail(employeeDetails.getEmail());
		employee.setPhone(employeeDetails.getPhone());
		employeeRepository.save(employee);
		return ResponseEntity.ok().body(employee);
	}

	@Override
	public ResponseEntity<Employee> deleteEmployeeById(int id) throws EmployeeNotFoundException {
		employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this Id"));
		employeeRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Employee> saveAllEmployee(List<Employee> employee) {
		employeeRepository.saveAll(employee);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Employee> deleteAllEmployee() {
		employeeRepository.deleteAll();
		return ResponseEntity.ok().build();
	}

}
