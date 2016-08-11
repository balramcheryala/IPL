package com.bridgelabz.bridgembass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.bridgembass.database.model.AuthUser;
import com.bridgelabz.bridgembass.dto.AuthUserBean;
import com.bridgelabz.bridgembass.service.AuthUserservice;

@RestController
public class AuthController {

	@Autowired
	private AuthUserservice authuserservice;

	@RequestMapping(value = { "/authsave" }, method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("command") AuthUserBean authuserbean, BindingResult result) {

		AuthUser authuser = prepareModel(authuserbean);
		authuserservice.save(authuser);
		return new ModelAndView("jump");

	}

	// New User
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("newuser");
		return model;
	}

	//dashboard
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("dashboard");
		return model;
	}
	// Sign in By
	@RequestMapping(value = { "/signinby" }, method = RequestMethod.GET)
	public ModelAndView signInBy() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("sign-in");
		return model;
	}

	// id_secure code
	@RequestMapping(value = { "/id_secure" }, method = RequestMethod.GET)
	public ModelAndView id_secure() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.addObject("project", "Set Redirect Uri as http://localhost:8081/projectname/__/auth/{provider}");
		model.setViewName("id_secure");
		return model;
	}

	// getUser
	private String getUser() {
		String userName = null;
		// The simplest way to retrieve the currently authenticated principal is
		// via a static call to the SecurityContextHolder
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Getting the username from Security Context Holder");
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	// prepare Model
	private AuthUser prepareModel(AuthUserBean authuserBean) {
		AuthUser student = new AuthUser();
		student.setEmail(authuserBean.getEmail());
		student.setProviders(authuserBean.getProviders());
		return student;
	}
}
