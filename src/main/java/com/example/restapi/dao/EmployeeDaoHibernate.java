package com.example.restapi.dao;

import java.util.List;

import com.example.restapi.entity.Employee;

public interface EmployeeDaoHibernate {
	
	public List<Employee> findAll();
	
	public Employee findEmpById(int theId);
	
	public void saveEmp(Employee emp);
	
	public void deleteEmpById(int id);
}
