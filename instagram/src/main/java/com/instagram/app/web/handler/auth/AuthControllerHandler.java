package com.instagram.app.web.handler.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.web.util.auth.AuthResponseScript;

@Controller
public class AuthControllerHandler {
	
	@ResponseBody
	@RequestMapping(value = "/auth/signin/error", method = RequestMethod.GET, produces = "text/html;charset=utf-8") // GET요청으로 로그인 오류 나타내는 어노테이션
	public String signinValidCheck(String msg) { // 벨리데이션 성공 실패 메세지 보내주는 메서드 
		return new AuthResponseScript().signinValidScript(msg); //벨리데이션 script 안에 매개변수로 메세지 넣어주고 리턴하기 
	}
}
