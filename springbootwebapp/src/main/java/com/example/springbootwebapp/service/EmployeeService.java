package com.example.springbootwebapp.service;

import java.util.List;

import com.example.springbootwebapp.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee e);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	Employee updateEmployee(Employee e, long id);

	void deleteEmployee(long id);

	boolean hasEmployee(long id);
}
