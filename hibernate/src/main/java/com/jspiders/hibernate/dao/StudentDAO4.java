package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.Student;

public class StudentDAO4 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransacton;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransacton.begin();
		
		Student student = entityManager.find(Student.class, 1);
		entityManager.persist(student);
		System.out.println(student);
		
		entityTransacton.commit();
		closeConnection();
		
	}
	
	public static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("employee");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransacton = entityManager.getTransaction();
	}
	
	public static void closeConnection() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if(entityManager!=null) {
			entityManager.close();
		}
		if(entityTransacton!=null) {
			if(entityTransacton.isActive()) {
				entityTransacton.rollback();
			}
		}
		
	}
}
