package com.jspiders.onetomanyuni.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanyuni.dto.Company;
import com.jspiders.onetomanyuni.dto.Employee;


public class CompanyDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Employee employee1 = new Employee();
		employee1.setName("Simran");
		employee1.setEmail("simran@gmail.com");
		employee1.setSalary(30000);
		
		Employee employee2 = new Employee();
		employee2.setName("Saniya");
		employee2.setEmail("saniya@gmail.com");
		employee2.setSalary(35000);
		
		Company company = new Company();
		company.setName("TECH-MAHINDRA");
		company.setAddress("MUMBAI");
		company.setEmployees(Arrays.asList(employee1,employee2));
		entityManager.persist(company);
	
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
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
