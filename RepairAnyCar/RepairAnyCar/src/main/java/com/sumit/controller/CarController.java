package com.sumit.controller;

import javax.servlet.http.HttpSession;
import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumit.dao.CustomerDAO;
import com.sumit.dao.VehicleDAO;
import com.sumit.pojo.Customer;
import com.sumit.pojo.Vehicle;
import com.sumit.validation.CustomerValidation;

@Controller
@RequestMapping("/car")
public class CarController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewCarForm(Model model, Customer customer, Vehicle vehicle) {
		
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("customer", customer);
	
		return "car";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String carRegister(@ModelAttribute("vehicle") Vehicle vehicle, VehicleDAO vehicleDao ,BindingResult br, HttpSession session,CustomerValidation customerValidation, Model model, CustomerDAO customerDao) {
		
		int id = (Integer) session.getAttribute("customerId");
		Customer customer = (Customer)session.getAttribute("customer");
		vehicle.setCustomer(customer);
		customer.getVehicles().add(vehicle);
		vehicleDao.saveVehicle(vehicle);
		customerDao.saveAndUpdate(customer);
		
		session.setAttribute("customer", customer);
		model.addAttribute("vehicle", vehicle);
		//model.addAttribute("customer", customer);
		
		
		return "success";
//		
//		customer.getVehicles().add(customer.getVehicles())
		
		
		
	}
	
}
