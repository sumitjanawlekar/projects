package com.sumit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumit.dao.ServiceCenterDAO;
import com.sumit.pojo.ServiceCenter;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String serviceCenterForm(@ModelAttribute("serviceCenter") ServiceCenter serviceCenter, Model model) {

		model.addAttribute("serviceCenter", serviceCenter);
		return "serviceCenterRegister";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String serviceCenterRegister(@ModelAttribute("serviceCenter") ServiceCenter serviceCenter,
			HttpSession session, Model model, ServiceCenterDAO serviceCenterDAO) {

		serviceCenterDAO.saveServiceCenter(serviceCenter);
		model.addAttribute("serviceCenter", serviceCenter);

		model.addAttribute("action", "Registered");
		return "ServiceCenterRegisterSuccess";
	}

	public String delete(@ModelAttribute("serviceCenter") ServiceCenter serviceCenter, HttpSession session, Model model,
			ServiceCenterDAO serviceCenterDAO) {

		model.addAttribute("action", "Deleted");
		return "ServiceCenterRegisterSuccess";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteServiceCenter(@RequestParam("serviceCenterId") int serviceCenterId,
			ServiceCenterDAO serviceCenterDAO, HttpSession session) {
		serviceCenterDAO.deleteServiceCenter(serviceCenterId);

		return "adminHome";
	}
}
