package com.suraj.client;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	private String name;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "passport_id")
	private Passport passport;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int p_id, String name, Passport passport) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.passport = passport;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", name=" + name + ", passport=" + passport + "]";
	}
	
	
	
}
