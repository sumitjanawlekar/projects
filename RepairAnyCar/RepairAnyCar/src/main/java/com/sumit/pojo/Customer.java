package com.sumit.pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	
	
	private ServiceCenter serviceCenter;
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public ServiceCenter getServiceCenter() {
		return serviceCenter; 
	}

	public void setServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}
	
	
}
