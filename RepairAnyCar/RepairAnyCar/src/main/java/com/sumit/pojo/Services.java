package com.sumit.pojo;

import java.util.ArrayList;
import java.util.List;

public class Services {

	private String serviceName;
	private String serviceDescription;
	private List<ServiceCenter> ServiceCenter = new ArrayList<ServiceCenter>();
	
	
	public List<ServiceCenter> getServiceCenter() {
		return ServiceCenter;
	}
	public void setServiceCenter(List<ServiceCenter> serviceCenter) {
		ServiceCenter = serviceCenter;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
	
}
