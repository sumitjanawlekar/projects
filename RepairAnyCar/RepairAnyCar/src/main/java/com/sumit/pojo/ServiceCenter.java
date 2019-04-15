package com.sumit.pojo;

import java.util.ArrayList;
import java.util.List;

public class ServiceCenter extends User {

	private String ServiceCenterCode;
	private List<Services> services = new ArrayList<Services>();
	private List<Customer> customer = new ArrayList<Customer>();


	public String getServiceCenterCode() {
		return ServiceCenterCode;
	}

	public void setServiceCenterCode(String serviceCenterCode) {
		ServiceCenterCode = serviceCenterCode;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}
	
	
}
