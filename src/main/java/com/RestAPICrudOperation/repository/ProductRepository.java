package com.RestAPICrudOperation.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.RestAPICrudOperation.model.Product;
import com.RestAPICrudOperation.query.Query;

@Repository
public class ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private Query query;

	@Transactional
	public Integer save(Product p) {

		Integer i = (Integer) hibernateTemplate.save(p);

		return i;

	}

	public Product findyid(int id) {

		Product product = hibernateTemplate.get(Product.class, id);

		return product;

	}

	public Product findbyname(String name) {

		Session session = sessionFactory.openSession();

		String query = Query.finbyname;

		org.hibernate.query.Query q = session.createQuery(query);

		q.setParameter("X", name);

		Product product = (Product) q.uniqueResult();

		session.close();

		return product;

	}
	
	
	public List<Product> getall(){
		
		List<Product> loadAll = hibernateTemplate.loadAll(Product.class);
		
		return loadAll;
	}

	public Integer updateprice(String name,double price) {
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		String q = Query.updateprice;
		
	 org.hibernate.query.Query query = session.createQuery(q);
	 
	 query.setParameter("Y",name );
	 query.setParameter("X", price);
	 
	 int executeUpdate = query.executeUpdate();
	 
	 session.getTransaction().commit();
	 
	 session.close();
	  
	 return executeUpdate;
	 
		
		
	}
}
