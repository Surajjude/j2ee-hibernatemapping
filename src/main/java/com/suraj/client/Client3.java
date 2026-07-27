package com.suraj.client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

public class Client3 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();
		
		config.addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		
//		String sql = "SELECT * FROM product";
//		NativeQuery<Product> nativeQuery = session.createNativeQuery(sql, Product.class);
		String hql = "FROM Product";

//		Query<Product> query = session.createQuery(hql);
//		List<Product> list= query.list();
		
		
		String sql = "SELECT * FROM product WHERE cat =:cat";
		NativeQuery<Product> nativeQuery = session.createNativeQuery(sql, Product.class);
		nativeQuery.setString("cat", "Electronics");
		List<Product> list = nativeQuery.getResultList();
		list.forEach(p->System.out.println(p));
		
		
	}

	
}
