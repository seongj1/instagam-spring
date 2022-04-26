package com.instagram.app.service;

import com.instagram.app.domain.user.User;
import com.instagram.app.web.dto.auth.SignupRequestDto;

public interface AuthService {
	public boolean checkUsername(String username);
//	public int checkName(String name);
	public boolean signup(SignupRequestDto signupRequestDto);
	public User signin(String username, String password);
}
