package com.sumit.controller;

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
import com.sumit.pojo.Booking;
import com.sumit.pojo.Customer;
import com.sumit.pojo.ServiceCenter;

@Controller
@RequestMapping("/serviceCenter")
public class ServiceCenterController {

	String vehicleNumber;
	String serviceCenterName;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String serviceCenter(@ModelAttribute("serviceCenter") ServiceCenter serviceCenter,
			ServiceCenterDAO serviceCenterDao, Model model, HttpSession session) {
		List<ServiceCenter> list = serviceCenterDao.serviceCenterList();
		model.addAttribute(list);
		session.setAttribute("list", list);
		return "ServiceCenterList";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, params = "serviceCenterId")
	public String serviceCenterDashboard(@RequestParam(value = "serviceCenterId") int serviceCenterId,
			@ModelAttribute("serviceCenter") ServiceCenter serviceCenter, HttpSession session, Model model,
			ServiceCenterDAO serviceCenterDAO) {
		serviceCenter = serviceCenterDAO.serviceCenterDashboad(serviceCenterId);
		session.setAttribute("serviceCenter", serviceCenter);
		model.addAttribute("serviceCenter", serviceCenter);
//		String serviceCenterName = serviceCenter.getServiceCenterName();
		// System.out.println(serviceCenterId);
		return "serviceCenterDashboard";
	}

	@RequestMapping(value = "/serviceForm", method = RequestMethod.GET)
	public String viewServiceForm(@ModelAttribute("booking") Booking booking, Model model, HttpSession session) {
		model.addAttribute("booking", booking);
		// Customer c = (Customer) session.getAttribute("customer");
		return "serviceBook";
	}

	@RequestMapping(value = "/serviceForm", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("booking") Booking booking, Customer customer, HttpSession session,
			CustomerDAO customerDao, ServiceCenterDAO serviceCenterDao) {

		String appointmentDate = booking.getAppointmentTime();

		// get customer object from session
		// get service center from session
		Customer customerSession = ((Customer) session.getAttribute("customer"));
		ServiceCenter serviceCenterSession = (ServiceCenter) session.getAttribute("serviceCenter");

		booking.setStatus("Pending");
		booking.setCustomer(customerSession);
		booking.setServiceCenter(serviceCenterSession);
		session.setAttribute("booking", booking);

		serviceCenterSession.getBooking().add(booking);
		customerSession.getBooking().add(booking);
		booking.setStatus("Pending");

		serviceCenterDao.booking(booking);

		serviceCenterName = serviceCenterSession.getServiceCenterName();
		vehicleNumber = booking.getVechileNumber();
		customerDao.saveAndUpdate(customerSession);
		serviceCenterDao.saveOrUpdate(serviceCenterSession);

		// persist both in db

		session.setAttribute("customer", customerSession);
		session.setAttribute("serviceCenter", serviceCenterSession);

		try {
			sendEmail(customerSession);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(appointmentDate);
		return "bookingSuccess";
	}

	private void sendEmail(Customer customer) throws EmailException {
		String customerName = customer.getFirstName();
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);

		email.setAuthenticator(new DefaultAuthenticator("bscms2018@gmail.com", "password@12345"));
		email.setSSLOnConnect(true);
		email.setFrom("no-reply@msis.neu.edu");
		email.setSubject("Test Mail");
		email.setMsg(customerName + " Recieved Your Booking with " + serviceCenterName
				+ " for your Car with vehicle number " + vehicleNumber);
		email.addTo(customer.getEmailAddress());
		email.send();

	}

}
