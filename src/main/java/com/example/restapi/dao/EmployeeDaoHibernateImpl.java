package com.example.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.restapi.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDaoHibernate {
	
	//define field for entitymanager
	private EntityManager entityManager;
	//private Session currentSession = entityManager.unwrap(Session.class);
	
	//set up constructor injection
	public EmployeeDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create query
		
		
		//execute query and get result list
		
		// return the results
		return (List<Employee>) currentSession.createNativeQuery("select * from employee").getResultList();
	}


	@Override
	public Employee findEmpById(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return the employee
		return theEmployee;
	}


	@Override
	public void saveEmp(Employee emp) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
	}


	@Override
	public void deleteEmpById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.createQuery("delete from Employee e where e.id=:empId").setParameter("empId", id).executeUpdate() ;
	}

}
