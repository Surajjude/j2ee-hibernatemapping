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

public class Client4 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		
		config.addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Product.class);
		
		criteria.add(Restrictions.gt("price", 800));
		criteria.add(Restrictions.eq("cat", "Electronics"));
		
		ProjectionList projectionList = Projections.projectionList();
		
		projectionList.add(Projections.property("name"));
		projectionList.add(Projections.property("price"));
		
		criteria.setProjection(projectionList);
		
		List<Object[]> list = criteria.list();
		
		for(Object[] data:list) {
			System.out.println(data[0]+"------>"+data[1]);
		}
	}

}
