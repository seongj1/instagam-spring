package com.instagram.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.GET)
	public String getSignin() {
		return "auth/signin";
	}
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
	public String getSignup() {
		return "auth/signup";
		
	}
	@RequestMapping(value = "/profile/account", method = RequestMethod.GET)
	public String getAccount() {
		return "profile/account/account";
	}
}
