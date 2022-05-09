package com.instagram.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instagram.app.web.dto.auth.SignupRequestDto;

@Controller 
public class PageController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET) //get 요청으로 index페이지를 요청하는 어노테이션
	public String getIndex() { // index페이지를 열어주는 메서드 
		return "index"; //index페이지 맵핑 주소
	}
	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.GET) //get요청으로 signin페이지를 요청하는 어노테이션 
	public String getSignin() { // 로그인 페이지를 열어주는 메서드
		return "auth/signin";	// 로그인 페이지 맵핑 주소
	}
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET) //get요청으로 signup페이지를 요청하는 어노테이션
	public String getSignup() { // 회원가입 페이지를 열어주는 메서드
		return "auth/signup"; //회원가입 페이지 맵핑 주소
	}
	
	@RequestMapping(value = "/profile/account", method = RequestMethod.GET) //get요청으로 account페이지를 요청하는 어노테이션
	public String getAccount() { // 프로필 편집 페이지를 열어주는 메서드 
		return "profile/account/account"; // 프로필 편집 페이지 맵핑 주소
	}
	
	@RequestMapping(value = "/profile/account/password", method = RequestMethod.GET)
	public String getAccountPassword() {
		return "profile/account/account_password";
	}
}









