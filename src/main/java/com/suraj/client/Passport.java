package com.suraj.client;

import javax.persistence.*;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String passportNumber;

	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passport(int id, String passportNumber) {
		super();
		this.id = id;
		this.passportNumber = passportNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + "]";
	}

	
}
