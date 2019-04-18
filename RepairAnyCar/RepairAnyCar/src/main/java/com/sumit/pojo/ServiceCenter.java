package com.sumit.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ServiceCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String ServiceCenterId;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ServiceCenter_Services", joinColumns = {@JoinColumn(name = "ServiceCenterId")}, inverseJoinColumns = {@JoinColumn(name = "serviceId")})
	private List<Services> services ;
	
	@OneToMany(mappedBy = "serviceCenter", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Customer> customer;

	@Column
	private String serviceCenterName;

	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId")
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public void setServiceCenterId(String serviceCenterId) {
		this.ServiceCenterId = serviceCenterId;
	}


	public String getServiceCenterId() {
		return ServiceCenterId;
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
