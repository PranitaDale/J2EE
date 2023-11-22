package com.jspiders.serializationdeserialization.serialization.object.copy;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID=1L;
	
	int id;
	String name;
	String email;
	String password;
	
	public User(int id, String name, String email, String password) {
		super();
		this.id=id;
		this.name=name;
		this.email= email;
		this.password=password;
	}
	@Override
	public String toString() {
		return "user [id= "+ id +", name= "+ name +", email= "+ email +", password="+ password +"]";		
	}
}
