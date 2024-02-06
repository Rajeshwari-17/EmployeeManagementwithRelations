package com.example.springbootwebapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springbootwebapp.exception.ResourceNotFoundException;
import com.example.springbootwebapp.model.Employee;
import com.example.springbootwebapp.repository.EmployeeRepository;
import com.example.springbootwebapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee e) {
		return this.employeeRepository.save(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		}
		throw new ResourceNotFoundException("Employee", "id", id);
	}

	@Override
	public Employee updateEmployee(Employee e, long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			emp.get().setFirstName(e.getFirstName());
			emp.get().setLastName(e.getLastName());
			emp.get().setEmail(e.getEmail());
			employeeRepository.save(emp.get());
			return emp.get();
		}
		throw new ResourceNotFoundException("Employee", "id", id);
	}

	@Override
	public void deleteEmployee(long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.deleteById(id);
		}
		throw new ResourceNotFoundException("Employee", "id", id);
	}

	public boolean hasEmployee(long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp.isPresent();
	}

}
