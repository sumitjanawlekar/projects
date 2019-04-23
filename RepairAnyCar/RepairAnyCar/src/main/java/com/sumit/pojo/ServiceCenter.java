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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class ServiceCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String ServiceCenterId;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "ServiceCenter_Services", joinColumns = {@JoinColumn(name = "ServiceCenterId")}, inverseJoinColumns = {@JoinColumn(name = "serviceId")})
	private List<Services> services ;

	
	@OneToMany(mappedBy = "serviceCenter", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Customer> customer;

	@Column
	private String serviceCenterName;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "addressId")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Address address;
	
	@OneToMany(mappedBy = "serviceCenter")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Booking> booking = new ArrayList<Booking>();
	

	public List<Booking> getBooking() {
		return booking;
	}


	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}


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
