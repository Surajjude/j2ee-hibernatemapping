package com.suraj.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String department;
	
	@OneToMany(mappedBy="department",cascade = CascadeType.ALL)
	private List<Employee> employee = new ArrayList<>();

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String department, List<Employee> employee) {
		super();
		this.department = department;
		this.employee = employee;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", department=" + department + ", employee=" + employee + "]";
	}

	
	
}
