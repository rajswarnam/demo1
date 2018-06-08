package com.example.demo.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId()+"Name ::"+getName()+"  Role ::"+getRole();
	}

	protected User() {
		super();
	}

	public User(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.name = string;
		this.role = string2;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
