package com.suraj.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Client5 {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		
		config.addAnnotatedClass(Department.class);
		config.addAnnotatedClass(Employee.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Department d = new Department();
		d.setDepartment("IT");
		
		Employee e1 = new Employee();
		e1.setName("Suraj");
		e1.setDepartment(d);
		
		d.getEmployee().add(e1);

		session.save(d);
		tx.commit();
		
		
	}

}
