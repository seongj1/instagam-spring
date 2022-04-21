package com.instagram.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.domain.user.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private UserRepository userRepository;  //레퍼지토리 객체를 @Autowired로 가져온다.
	
	@Override
	public boolean checkUsername(String username) {
		return userRepository.checkUsername(username) != 0 ? true : false; //레퍼지토리에서 받은 0또는1의 값을 판단해서 true 또는 false 값으로 리턴
	}
	
	
//	@Override
//	public int checkName(String name) {
//		return userRepository.checkname(name);
//	}
}
