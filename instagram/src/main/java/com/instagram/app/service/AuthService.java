package com.instagram.app.service;

import com.instagram.app.web.dto.auth.SignupRequestDto;

public interface AuthService {
	public boolean checkUsername(String username);
//	public int checkName(String name);
	public boolean signup(SignupRequestDto signupRequestDto);
}
