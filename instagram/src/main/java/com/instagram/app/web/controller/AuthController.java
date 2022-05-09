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
	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.POST) // POST요청으로 해당 메서드를 요청하는 어노테이션 
	public String signinSubmit(String username, String password, HttpServletRequest request) throws UnsupportedEncodingException {
		AuthValidation authValidation = new AuthValidation(); //Validation 객체 생성
		Map<Boolean, String> usernameIsNull = authValidation.isNull("username", username); // isNull 메서드를 이용해서 username null 값 체크
		Map<Boolean, String> passwordIsNull = authValidation.isNull("password", password); // isNull 메서드를 이용해서 password null 값 체크
		
		if(usernameIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(usernameIsNull.get(true), "UTF-8"); // username이 오류 났을 때 알림창 띄워주기
		}
		if(passwordIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(passwordIsNull.get(true), "UTF-8"); // password가 오류 났을 때 알림창 띄워주기 
		} 
		
		User user = authService.signin(username, password); // authService안에 signin메서드에 매개변수로 username, password 넣어주고 이것을 User 객체의 user 변수의 담기
		if(user != null) { //user 변수가 null이 아니라면
			//session
			HttpSession session = request.getSession(); // session 객체를 생성해서 변수에 저장
			session.setAttribute("principal", user); // session에 set으로 principal을 키값으로 하는 user 정보 저장 
		}else {
			//로그인 실패 메세지 전달
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode("로그인 정보를 확인해 주세요.", "UTF-8"); // 로그인이 실패 했을 때 알림창 띄워주기
		}
		
		return "redirect: /app/"; // 로그인이 됐을 때 index 페이지로 보내기
	}
	
	@ResponseBody //데이터만 주고 받을 때 사용하는 어노테이션
	@RequestMapping(value = "/auth/signup", method = RequestMethod.POST, produces = "text/html;charset=utf-8") // POST요청으로 해당 메서드를 요청하는 어노테이션 encoding도 UTF-8로 바꿔준다.
	public String signupSubmit(SignupRequestDto signupRequestDto) {//회원가입 할 때 데이터값 받아서 넘기는 메서드
		boolean result = authService.signup(signupRequestDto); // authService안에 signup메서드에 매개변수로 Dto를 넣어주고 이것들을 boolean 자료형 변수 result에 넣어준다
		AuthResponseScript script = new AuthResponseScript(); // 회원가입이 완료되었다고 알려줄 html을 만든 script 객체를 생성해 준다.
		return script.signupScript(result); // script 안에 메서드를 불러와 매개변수로 result를 넣어준다.
	}
	
	@ResponseBody //데이터만 주고 받을 때 사용하는 어노테이션
	@RequestMapping(value = "/auth/username/check", method = RequestMethod.GET)// requestMapping 으로 get요청을 하는 어노테이션
	public String usernameCheck(String username) { //회원가입할 때 이미 생성된 username이 있는지 확인하는 메서드
		return Boolean.toString(authService.checkUsername(username)); // authService에 있는 메서드에 username을 매개변수로 넣어서 boolean형으로 받은 리턴 값을 toString으로 변환하여 리턴
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET) // get요청으로 해당 메서드를 요청하는 어노테이션 
	public String signout(HttpServletRequest request) { // 로그아웃을 하기 위해 request 객체를 매개변수로 받아온다. 
		HttpSession session = request.getSession(); // session 객체를 생성하고 
		session.invalidate(); // session 속의 모든 데이터를 지운다.
		return "redirect: /app/auth/signin"; // 다시 로그인 페이지로 이동시킨다.
	}
	
	
	
}





