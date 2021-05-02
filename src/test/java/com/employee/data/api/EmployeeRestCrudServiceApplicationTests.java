package com.employee.data.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.data.api.model.Employee;
import com.employee.data.api.repository.EmployeeRepository;

@SpringBootTest
class EmployeeRestCrudServiceApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * tests the save functionality of employee
	 */
	@Test
	public void testEmployeeSave() {
		Employee employee = new Employee();
		employee.setId(12);
		employee.setFirst_name("test");
		employee.setLast_name("test");
		employee.setEmail("test@gmail.com");
		employee.setPhone(9788474748383l);

		employeeRepository.save(employee);
		assertNotNull(employeeRepository.findById(12).get());
	}

	/**
	 * tests the get functionality of employee to get list of records
	 */
	@Test
	public void testGetAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		assertThat(employees.size() > 0);
	}

	/**
	 * tests the findById functionality of employee to get employee object based on
	 * ID
	 */
	@Test
	public void testEmployeeById() {
		Employee employee = employeeRepository.findById(10).get();
		assertEquals("test", employee.getFirst_name());
	}

	/**
	 * tests the update functionality of employee,In order to update employee
	 * records based on input
	 */
	@Test
	public void testEmployeeUpdate() {
		Employee employee = employeeRepository.findById(10).get();
		employee.setLast_name("test1");
		employeeRepository.save(employee);
		assertNotEquals("test", employeeRepository.findById(10).get().getLast_name());
	}

	/**
	 * tests the delete functionality of employee
	 */
	@Test
	public void testEmployeeDeleteById() {
		Employee employee = employeeRepository.findById(10).get();
		employeeRepository.deleteById(employee.getId());
		assertThat(employeeRepository.existsById(employee.getId())).isFalse();
	}

}
