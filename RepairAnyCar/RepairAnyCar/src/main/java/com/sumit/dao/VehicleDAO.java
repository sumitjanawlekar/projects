package com.sumit.dao;

import com.sumit.pojo.Vehicle;

public class VehicleDAO extends DAO {

	public void saveVehicle(Vehicle vehicle) {
		
		try {
			begin();
			getSession().save(vehicle);
			getSession().getTransaction().commit();
			close();
		}
		catch(Exception e) {
			rollback();
			close();
		}
	}
}
