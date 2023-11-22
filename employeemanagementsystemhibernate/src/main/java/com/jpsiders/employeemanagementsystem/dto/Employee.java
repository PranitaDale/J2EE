package com.jpsiders.employeemanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employee_info")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, name="employee_name")
	private String name;
	@Column(nullable=false, unique=true, name="employee_email")
	private String email;
	@Column(nullable=false, name="employee_salary")
	private double salary;
	

}
