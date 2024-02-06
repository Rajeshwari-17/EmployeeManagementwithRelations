package com.example.springbootwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootwebapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
