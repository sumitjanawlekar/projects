package com.sumit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/car")
public class CarController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewCarForm() {
		
		return "car";
	}
}
