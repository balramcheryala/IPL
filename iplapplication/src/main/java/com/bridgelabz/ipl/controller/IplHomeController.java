package com.bridgelabz.ipl.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgelabz.ipl.database.dao.IplDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController is processed if an appropriate HandlerMapping-HandlerAdapter pair is configured
//@RestController annotation that is itself annotated with @Controller and @ResponseBody.
@RestController
public class IplHomeController {

	// Marks a constructor, field, setter method or config method as to be
	// autowired by Spring's dependency injection facilities.
	@Autowired
	private IplDaoImpl ipldao;
	@Autowired
	public SessionFactory sessionfactory;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Login Page");
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = { "/userpage" }, method = RequestMethod.GET)
	public ModelAndView userPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "MBASSBRIDGE ");
		model.addObject("user", getUser());
		model.setViewName("user");
		return model;
	}
	//DashBoard
	
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashBoard() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "MBASSBRIDGE ");
		model.addObject("user", getUser());
		model.setViewName("dashboard");
		return model;
	}
	// IplHomePage
	@RequestMapping(value = "/ipl", method = RequestMethod.GET)
	public ModelAndView iplHomepage() {
		System.out.println("Mapping to Ipl Home Page");
		return new ModelAndView("iplhome");
	}

	// Request Mapping For Player
	@RequestMapping(value = "/players/{request}", method = RequestMethod.GET)
	public ModelAndView playersList(@PathVariable("request") String ipl) {
		System.out.println(ipl);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("playerslist", ipldao.iplplayergenerate(ipl));
		System.out.println("Displaying " + ipl + "player List");
		return new ModelAndView("playerlist", model);
	}

	// Request Mapping For Team
	@RequestMapping(value = "/teams/{teamrequest}", method = RequestMethod.GET)
	public ModelAndView TeamList(@PathVariable("teamrequest") String iplteam) {
		System.out.println(iplteam);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("teamlist", ipldao.iplteamgenerate(iplteam));
		System.out.println("Displaying " + iplteam + "Team List");
		return new ModelAndView("Teams", model);
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
