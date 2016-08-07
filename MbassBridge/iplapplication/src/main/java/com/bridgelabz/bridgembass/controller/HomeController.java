package com.bridgelabz.bridgembass.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController is processed if an appropriate HandlerMapping-HandlerAdapter pair is configured
//@RestController annotation that is itself annotated with @Controller and @ResponseBody.
@RestController
public class HomeController {

	// Marks a constructor, field, setter method or config method as to be
	// autowired by Spring's dependency injection facilities.
	@Autowired
	public SessionFactory sessionfactory;

	// Landing Page Login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Login Page");
		model.addObject("name", "BRIDGEMBASS");
		model.setViewName("login");
		return model;
	}

	// UserPage After Success Login
	@RequestMapping(value = { "/userpage" }, method = RequestMethod.GET)
	public ModelAndView userPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("user");
		return model;
	}
	// DashBoard

	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashBoard() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("dashboard");
		return model;
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

	// Sign in By
	@RequestMapping(value = { "/signinby" }, method = RequestMethod.GET)
	public ModelAndView signInBy() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("sign-in");
		return model;
	}

	// ERROR
	@RequestMapping(value = { "/***" }, method = RequestMethod.GET)
	public ModelAndView error() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("404");
		return model;
	}

	@RequestMapping(value = { "/accessdenied" }, method = RequestMethod.GET)
	public ModelAndView accessDeniedPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("message", "Either username or password is incorrect.");
		System.out.println("Access Denined");
		model.setViewName("accessdenied");
		return model;
	}

	private String getUser() {
		String userName = null;
		// The simplest way to retrieve the currently authenticated principal is
		// via a static call to the SecurityContextHolder
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Get User(): getting the username from Security Context Holder");
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}