package org.jrue.controller;

import org.jrue.domain.User;
import org.jrue.persistence.UserService;
import org.jrue.validator.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRegistrationValidator userRegistrationValidator;
	
	@RequestMapping(value="/registration.html",method= RequestMethod.GET)
	public String showRegistration(Model model) {
		model.addAttribute("users", userService.getAllUser());
		model.addAttribute("user", new User());
		return "registration";
	}
}
