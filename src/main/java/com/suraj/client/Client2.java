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

public class Client2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		
		config.addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Product.class);
		
		//maximum price
		criteria.setProjection(Projections.max("price"));
		Integer max = (Integer) criteria.uniqueResult();
		
		
		criteria.setProjection(Projections.min("price"));
		Integer min = (Integer) criteria.uniqueResult();

		criteria.setProjection(Projections.count("id"));
		Long count = (Long) criteria.uniqueResult();


		criteria.setProjection(Projections.sum("price"));
		Long sum = (Long) criteria.uniqueResult();
		
		criteria.setProjection(Projections.avg("price"));
		Double avg = (Double) criteria.uniqueResult();
		
		
		System.out.println("Maximum Price : "+max);
		System.out.println("Minimum Price : "+min);
		System.out.println("Count of id : "+count);
		System.out.println("Total Worth : "+sum);
		System.out.println("Average Price : "+avg);
	}

}
