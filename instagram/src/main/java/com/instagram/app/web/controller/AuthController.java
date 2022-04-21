package com.instagram.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.service.AuthService;
import com.instagram.app.web.dto.auth.SignupRequestDto;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
	public String getSignup() {
		return "/auth/signup";
		
	}
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.POST)
	public String signupSubmit(SignupRequestDto signupRequestDto) {
		System.out.println(signupRequestDto);
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/username/check1", method = RequestMethod.GET)
	public String usernameCheck(String username) {
		return Boolean.toString(authService.checkUsername(username));
	}
}
