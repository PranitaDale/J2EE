package com.jspiders.employeemanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.employeemanagementsystem.dto.Employee;

public class EmployeeDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public void addEmployee(Employee employee) {
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(employee);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	public void deleteEmployee(int id) {
		openConnection();
		entityTransaction.begin();
		
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	public void getAllEmployee() {
		openConnection();
		entityTransaction.begin();
		
		Query query = entityManager.createQuery("SELECT empl ");
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("employee");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if(entityManager!=null) {
			entityManager.close();
		}
		if(entityTransaction!=null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	

}
