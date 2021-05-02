package com.employee.data.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.data.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
