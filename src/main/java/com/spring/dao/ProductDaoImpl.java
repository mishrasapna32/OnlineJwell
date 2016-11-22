package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.dao.ProductDao;
import com.spring.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
		public SessionFactory getSessionFactory() {
		return sessionFactory;
}
		public void setSessionFactory(SessionFactory sessionFactory) {
			
			this.sessionFactory = sessionFactory;
			}

		public List<Product> getAllProducts() {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			//selction all the records from the table
			List<Product> products=session.createQuery("from Product").list();
			session.close();
			return products;
		}
		public Product getPrductById(int i) {
			// reading recored fromthe table.
			Session session=sessionFactory.openSession();
			Product product=(Product)session.get(Product.class,i);
			session.close();
			return product;
		}
		public void addProduct(Product product) {
			Session session=sessionFactory.openSession();
		session.save(product);
			session.close();	
	}
 
		
		public void editProduct(Product product) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			//update product set ...where id=?
			session.update(product);
			session.flush();
			session.close();
			
		}
		
		
			
			
		public void deleteProduct(int id) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			//select * from book where isbn=?
			Product product=(Product)session.get(Product.class, id);
			//delete from book where isbn=?
			session.delete(product);
			//commit the changes
			//changes to the database will become permanent
			session.flush();
			//closing the connection with the database.
			session.close();//close the session
		}
		
}
