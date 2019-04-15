package com.sumit.dao;

import org.hibernate.Query;

import com.sumit.pojo.Customer;

public class CustomerDAO extends DAO {

	
	public Customer customerLogin(Customer customer) {
		
		String hql = "from com.sumit.pojo.Customer as c where c.firstName = ? and c.password = ?";
		try {
			begin();
			
			Query query = getSession().createQuery(hql);
			query.setParameter(0, customer.getEmailAddress());
			query.setParameter(1, customer.getPassword());
			customer = (Customer)query.uniqueResult();
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
