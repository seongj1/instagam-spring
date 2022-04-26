package com.instagram.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.auth.PrincipalService;
import com.instagram.app.domain.user.User;
import com.instagram.app.domain.user.UserRepository;
import com.instagram.app.web.dto.auth.SignupRequestDto;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private UserRepository userRepository;  //레퍼지토리 객체를 @Autowired로 가져온다.

	@Autowired
	private PrincipalService principalService;
	
	@Override
	public boolean checkUsername(String username) {
		return userRepository.checkUsername(username) != 0 ? true : false; //레퍼지토리에서 받은 0또는1의 값을 판단해서 true 또는 false 값으로 리턴
	}
	
	
//	@Override
//	public int checkName(String name) {
//		return userRepository.checkname(name);
//	}
	
	@Override
	public boolean signup(SignupRequestDto signupRequestDto) {
		int result = userRepository.signup(signupRequestDto.toEntity());
		return result != 0;
	}
	

	@Override
	public User signin(String username, String password) {
		User user = principalService.loadUserByUsername(username);
		if(user != null) {
			if(!principalService.passwordCheck(password, user)) {
				return null;
			}
		}
		return user;
	}
}
