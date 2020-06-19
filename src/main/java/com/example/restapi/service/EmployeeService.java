package com.example.restapi.service;

import java.util.List;

import com.example.restapi.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findEmpById(int theId);
	
	public void saveEmp(Employee emp);
	
	public void deleteEmpById(int id);
}
