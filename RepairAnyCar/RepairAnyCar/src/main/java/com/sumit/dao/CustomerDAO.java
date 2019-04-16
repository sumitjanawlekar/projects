package com.sumit.dao;

import java.util.List;

import org.hibernate.Query;

import com.sumit.pojo.Customer;

public class CustomerDAO extends DAO {

	
	public void saveCustomer(Customer customer) {
		try {
		begin();
		
		getSession().save(customer);
		getSession().getTransaction().commit();
		close();
		}
		catch(Exception e) {
			rollback();
			close();
		}
	}
	
	public Customer customerLogin(Customer customer) {
		
		String hql = "from Customer as c where c.emailAddress=:email and c.password=:pwd";
		try {
			begin();
			
		Query query = getSession().createQuery(hql);
//			query.setParameter("email", customer.getEmailAddress());
//			query.setParameter("password", customer.getPassword());
			//List cutomers= query.list();
		//Query query = session.createQuery(hql);
		query.setString("email", customer.getEmailAddress());
		query.setString("pwd", customer.getPassword());
		customer = (Customer)query.uniqueResult();
			//System.out.println("CUSTOMERS......."+results);
			
			commit();
			close();
		}
		catch(Exception e) {
			rollback();
			close();
		}
		
		return customer;
	}
}
