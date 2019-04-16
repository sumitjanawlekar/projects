package com.sumit.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ServiceCenter {

	@Id
	@Column(name = "ServiceCenterId", unique = true, nullable = false, length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ServiceCenterId;
	
	@OneToMany
	@JoinColumn(name = "serviceId")
	private List<Services> services ;
	
	@OneToMany
	@JoinColumn(name = "emailAddress")
	private List<Customer> customer;

	@Column
	private String serviceCenterName;

	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
	
	public String getServiceCenterId() {
		return ServiceCenterId;
	}

	public void setServiceCenterId(String serviceCenterId) {
		ServiceCenterId = serviceCenterId;
	}

	public String getServiceCenterName() {
		return serviceCenterName;
	}

	public void setServiceCenterName(String serviceCenterName) {
		this.serviceCenterName = serviceCenterName;
	}

	public String getServiceCenterCode() {
		return ServiceCenterId;
	}

	public void setServiceCenterCode(String serviceCenterCode) {
		ServiceCenterId = serviceCenterCode;
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
