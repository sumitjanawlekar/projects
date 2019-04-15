package com.sumit.pojo;

public abstract class Vehicle {

	private String company;
	private String model;
	private String numberPlate;
	private String vechileType;
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getVechileType() {
		return vechileType;
	}
	public void setVechileType(String vechileType) {
		this.vechileType = vechileType;
	}
	
	
}
