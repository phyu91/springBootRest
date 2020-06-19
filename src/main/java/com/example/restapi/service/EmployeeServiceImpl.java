package com.example.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.restapi.dao.EmployeeDaoHibernate;
import com.example.restapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDaoHibernate empDao;
	
	public EmployeeServiceImpl(EmployeeDaoHibernate theEmpDao) {
		empDao = theEmpDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return empDao.findAll();
	}

	@Override
	@Transactional
	public Employee findEmpById(int theId) {
		return empDao.findEmpById(theId);
	}

	@Override
	@Transactional
	public void saveEmp(Employee emp) {
		empDao.saveEmp(emp);

	}

	@Override
	@Transactional
	public void deleteEmpById(int id) {
		empDao.deleteEmpById(id);
	}

}
