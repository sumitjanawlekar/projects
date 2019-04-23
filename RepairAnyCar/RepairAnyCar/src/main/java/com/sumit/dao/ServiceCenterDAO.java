package com.sumit.dao;

import java.util.List;

import org.hibernate.Query;

import com.sumit.pojo.Booking;
import com.sumit.pojo.ServiceCenter;

public class ServiceCenterDAO extends DAO {

	public List<ServiceCenter> serviceCenterList() {
		
		String hql = "from ServiceCenter";
		List<ServiceCenter> list = null;
		try {
			begin();
			Query query = getSession().createQuery(hql);
			list = (List<ServiceCenter>)query.list();
			commit();
			close();
		}
		catch(Exception e) {
			rollback();
			close();
		}
		return list;
	}
	
	public ServiceCenter serviceCenterDashboad(int serviceCenterId) {
		
		String hql = "from ServiceCenter as s where s.ServiceCenterId = ?";
		ServiceCenter serviceCenter = null;
		try {
			begin();
			Query query = getSession().createQuery(hql);
			query.setInteger(0, serviceCenterId);
			serviceCenter = (ServiceCenter)query.uniqueResult();
			close();
		}
		catch (Exception e) {
			// TODO: handle exception
			rollback();
			close();
		}
		
		return serviceCenter;
	}
	
	public void saveOrUpdate(ServiceCenter serviceCenter) {
		
		try {
			begin();
			getSession().saveOrUpdate(serviceCenter);
			getSession().getTransaction().commit();
			close();
		}
		catch (Exception e) {
			// TODO: handle exception
			rollback();
			close();
		}
	}
	
	public void booking(Booking booking) {
		try {
			begin();
			getSession().save(booking);
			getSession().getTransaction().commit();
			close();
		}
		catch (Exception e) {
			// TODO: handle exception
			rollback();
			close();
		}
	}
}
