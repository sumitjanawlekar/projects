package com.sumit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumit.dao.ServiceCenterDAO;
import com.sumit.pojo.ServiceCenter;

@Controller
@RequestMapping("/serviceCenter")
public class ServiceCenterController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String serviceCenter(@ModelAttribute("serviceCenter") ServiceCenter serviceCenter , ServiceCenterDAO serviceCenterDao,Model model, HttpSession session) {
	
		List<ServiceCenter> list= serviceCenterDao.serviceCenterList();
		
		model.addAttribute(list);
		session.setAttribute("list", list);
		
		return "ServiceCenterList";
	}
	
	@RequestMapping(value = "/dashboard" , method = RequestMethod.GET, params = "serviceCenterId")
	public String serviceCenterDashboard( @RequestParam(value = "serviceCenterId") int serviceCenterId ,@ModelAttribute("serviceCenter") ServiceCenter serviceCenter, HttpSession session, Model model, ServiceCenterDAO serviceCenterDAO) {
		
		serviceCenter = serviceCenterDAO.serviceCenterDashboad(serviceCenterId);
		session.setAttribute("serviceCenter", serviceCenter);
		model.addAttribute("serviceCenter", serviceCenter);
		System.out.println(serviceCenterId);
		return "serviceCenterDashboard";
	}
}
