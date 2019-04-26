package com.sumit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumit.dao.CustomerDAO;
import com.sumit.dao.ServiceCenterDAO;
import com.sumit.dao.VehicleDAO;
import com.sumit.pojo.Booking;
import com.sumit.pojo.Customer;
import com.sumit.pojo.Vehicle;

@Controller
@RequestMapping("/partner")
public class PartnerController {
	String vehicleNumber;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String viewDashboard() {
		return "partnerDashboard";
	}

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String viewRequest(@ModelAttribute("booking") Booking booking, Model model, HttpSession session,
			ServiceCenterDAO serviceCenterDAO, VehicleDAO vehicleDAO) {

		List<Vehicle> vehiclesToService = new ArrayList<Vehicle>();
		List<Booking> bookings = new ArrayList<Booking>();
		int serviceCenterId = (Integer) session.getAttribute("serviceCenterId");
		bookings = serviceCenterDAO.getBooking(serviceCenterId);

		for (Booking b : bookings) {
			String vehicleNumber = b.getVechileNumber();
			Vehicle vehicle = vehicleDAO.getVehicle(vehicleNumber);
			vehiclesToService.add(vehicle);
		}

		model.addAttribute("vehicleToSerivce", vehiclesToService);
		model.addAttribute("bookings", bookings);
		session.setAttribute("bookings", bookings);
		return "partnerRequestView";
	}

	@RequestMapping(value = "/completed", method = RequestMethod.GET)
	public String requestCompleted(@RequestParam("bookingId") int bookingId, ServiceCenterDAO serviceCenterDAO,
			Booking booking, HttpSession session, CustomerDAO customerDAO) {

		booking = serviceCenterDAO.getCustomerBooking(bookingId);
		booking.setStatus("Completed");
		Customer customer = booking.getCustomer();

		customer.getBooking().add(booking);
		customerDAO.saveAndUpdate(customer);
		session.setAttribute("customer", customer);

		vehicleNumber = booking.getVechileNumber();
		serviceCenterDAO.updateBooking(booking);
		System.out.println(bookingId);

		try {
			sendEmail(customer);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "requestCompleted";
	}

	private void sendEmail(Customer customer) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);

		email.setAuthenticator(new DefaultAuthenticator("bscms2018@gmail.com", "password@12345"));
		email.setSSLOnConnect(true);
		email.setFrom("no-reply@msis.neu.edu");
		email.setSubject("Test Mail");
		email.setMsg("Dear " + customer.getFirstName() + " , Your Car with vehicle number" + vehicleNumber
				+ " is ready for pickup , Thankyou for choosing Repair Any Car");
		email.addTo(customer.getEmailAddress());
		email.send();

	}
}
