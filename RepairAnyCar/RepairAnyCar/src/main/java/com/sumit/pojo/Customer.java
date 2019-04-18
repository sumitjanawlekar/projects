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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String firstName;
	private String lastName;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "addressId")
	private Address address;
	
	
	private String emailAddress;
	
	private String password;
	
	@OneToMany( mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Vehicle> vehicles;
	
	@ManyToOne
	@JoinColumn(name = "ServiceCenterId")
	private ServiceCenter serviceCenter;
	
	
	public ServiceCenter getServiceCenter() {
		return serviceCenter;
	}
	public void setServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

}
