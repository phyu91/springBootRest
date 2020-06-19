package com.example.restapi.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dao.EmployeeDaoHibernate;
import com.example.restapi.entity.Employee;
import com.example.restapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeDaoHibernate empDao;
	private EmployeeService empService;
	
	public EmployeeController(EmployeeService theEmpService) {
		empService = theEmpService;
	}
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return empService.findAll();
	}
	
	// add mapping for GET /employee/{employeeId}
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee emp = empService.findEmpById(employeeId);
		if(emp == null) {
			throw new RuntimeException("Employee is not found = "+employeeId);
		}
		return emp;
	}
	
	// for update existing employee
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		empService.saveEmp(emp);
		return emp;
	}
	
	
	// add mapping for POST /employee - add new employee
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		empService.saveEmp(emp);
		return emp;		
	}
	
	// add mapping for delete
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee emp = empService.findEmpById(employeeId);
		if(emp == null) {
			throw new RuntimeException("Employee id not found ="+ employeeId);
		}
		empService.deleteEmpById(employeeId);
		return "Delete employee Id "+employeeId;
	}
}
