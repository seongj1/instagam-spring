package com.instagram.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.auth.PrincipalService;
import com.instagram.app.service.ProfileService;
import com.instagram.app.web.dto.account.AccountResponseDto;
import com.instagram.app.web.dto.account.AccountupdateReqDto;

@Controller
public class AccountController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private PrincipalService principalService;
	
	
	@ResponseBody
	@RequestMapping(value = "/profile/account/user", method = RequestMethod.GET, produces = "Application/json;charset=utf-8")
	public AccountResponseDto getProfile(int usercode) {
		System.out.println(usercode);
		return profileService.getAccountProfile(usercode);
	}
	
	@ResponseBody
	@RequestMapping(value = "/profile/account/update", method = RequestMethod.PUT)
	public String updateAccount(@RequestBody AccountupdateReqDto accountupdateReqDto, HttpServletRequest request) {
		boolean result = profileService.updateAccount(accountupdateReqDto);
		if(result == true) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", principalService.loadUserByUsername(accountupdateReqDto.getUsername()));
		}
		return Boolean.toString(result);
	}
}
