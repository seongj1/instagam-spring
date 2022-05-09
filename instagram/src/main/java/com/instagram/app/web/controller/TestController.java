package com.instagram.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String aaa() {
		return "auth/signup";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bbb", method = RequestMethod.GET, produces = "text/plain;charset.com")
	public String bbb() {
		return "hello";
	}
}
