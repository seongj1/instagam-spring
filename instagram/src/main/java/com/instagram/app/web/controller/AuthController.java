package com.instagram.app.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.auth.PrincipalService;
import com.instagram.app.domain.user.User;
import com.instagram.app.service.AuthService;
import com.instagram.app.web.dto.auth.SignupRequestDto;
import com.instagram.app.web.util.auth.AuthResponseScript;
import com.instagram.app.web.validation.auth.AuthValidation;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.POST)
	public String getSigninsubmit(String username, String password, HttpServletRequest request) throws UnsupportedEncodingException {
		AuthValidation authValidation = new AuthValidation();
		
		Map<Boolean, String> usernameIsNull = authValidation.isNull("username", username);
		Map<Boolean, String> passwordIsNull = authValidation.isNull("password", password);
		
		if(usernameIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(usernameIsNull.get(true), "UTF-8");
		}
		if(passwordIsNull  != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(passwordIsNull.get(true), "UTF-8");
		}
		
		User user = authService.signin(username, password);
		if(user != null) {
			//session
			HttpSession session = request.getSession();
			session.setAttribute("princlpal", user);
		}else {
			//로그인 실패 메세지 전달
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode("로그인 정보를 확인해 주세요.", "UTF-8");
		}
		
		return "redirect: /app/";
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/auth/signup", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String signupSubmit(SignupRequestDto signupRequestDto) {
		System.out.println(signupRequestDto);
		boolean result = authService.signup(signupRequestDto);
		AuthResponseScript script = new AuthResponseScript();
		return script.signupScript(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/username/check1", method = RequestMethod.GET)
	public String usernameCheck(String username) { //Service에서 받은 boolean 자료형을 String으로 변환하여 jsp에 리턴한다.
		return Boolean.toString(authService.checkUsername(username));
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/auth/name/check1", method = RequestMethod.GET)
//	public String nameCheck(String name) {
//		int result = authService.checkName(name);
//		System.out.println(result);
//		return Integer.toString(result);
//	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String signout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect: /app/auth/signin";
	}
}
