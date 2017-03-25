package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController{
	
	@RequestMapping(value = { "/", "home"}, method = RequestMethod.GET)
	public String homePage(ModelMap model){
		model.addAttribute("Greeting", "Hi, Welcome to mysite");
		return "index";
	}
	@RequestMapping(value = "/admin" , method = RequestMethod.GET)
	public String adminPage(ModelMap model){
		model.addAttribute("user", getPrincipal());
		return "admin";
	}
	@RequestMapping(value = "/student" , method = RequestMethod.GET)
	public String studentpage(ModelMap model){
		model.addAttribute("user", getPrincipal());
		return "student";
	}
	@RequestMapping(value = "/staff" , method = RequestMethod.GET)
	public String staffpage(ModelMap model){
		model.addAttribute("user", getPrincipal());
		return "staff";
	}
	@RequestMapping(value = "/Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model){
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginpage(){
		return "login";
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!= null){
			new SecurityContextLogoutHandler().logout(request , response , auth);
		}
		return "redirect:/login?logout";
	}
	private Object getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		}
		else{
			userName = principal.toString();
		}
		return userName;
	}
}