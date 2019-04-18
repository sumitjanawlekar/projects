package com.sumit.controller;

import javax.servlet.http.HttpSession;

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
	public String viewCarForm(Model model) {
		
		model.addAttribute("vehicle", new Vehicle());
	
		return "car";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String carRegister(@ModelAttribute("vehicle") Vehicle vehicle, VehicleDAO vehicleDao ,BindingResult br, HttpSession session,CustomerValidation customerValidation, Model model) {
		
		int id = (Integer) session.getAttribute("customerId");
		Customer customer = (Customer)session.getAttribute("customer");
		vehicle.setCustomer(customer);
		vehicleDao.saveVehicle(vehicle);
		customer.getVehicles().add(vehicle);
		//model.addAttribute("vehicle", vehicle);
		model.addAttribute("customer", customer);
		//System.out.println(id);
		
		return "success";
//		customer = (customerDao.customerLogin(vehicle));
//		customer.getVehicles().add(customer.getVehicles())
		
		
		
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		
		session.removeAttribute("customer");
		return "redirect: login";
		
	}
//		customerValidation.validate(customer,br);
//		if(br.hasErrors()) {
//			return "car";
//		}
//		else {
//			customerDao.saveCustomer(customer);
//			session.setAttribute("customer", customer);
//			return "success";
//		}
//	}
}
