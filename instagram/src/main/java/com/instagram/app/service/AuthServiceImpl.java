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
	private PrincipalService principalService; //principalService 객체를 @Autowired로 가져온다.
	
	@Override
	public boolean checkUsername(String username) { //username을 체크하는 boolean 자료형 메서드
		return userRepository.checkUsername(username) != 0 ? true : false; //userRepository에서 받은 0또는1의 값을 판단해서 true 또는 false 값으로 리턴
	}
	
	
//	@Override
//	public int checkName(String name) {
//		return userRepository.checkname(name);
//	}
	
	@Override
	public boolean signup(SignupRequestDto signupRequestDto) { // Dto객체를 매개변수로 받는 boolean 자료형 메서드
		int result = userRepository.signup(signupRequestDto.toEntity()); // userRepository 안에 signup메서드에다가 매개변수로 Dto안에 toEntity메서드를 넣어주고 이것을 int자료형 result에 넣는다.
		return result != 0; // int result 값이 1이면 true 0이면 false로 리턴해준다.
	}
	

	@Override
	public User signin(String username, String password) { // uesrname과 password를 배개변수로 받아 로그인 하는 메서드
		User user = principalService.loadUserByUsername(username); //uesr 자료형의 변수를 만들어 그 안에 principalService에 메서드안에 매개변수로 username을 넣는다.
		if(user != null) { //user 변수 안에 값이 null이 아니라면 
			if(!principalService.passwordCheck(password, user)) { //principalService안에 메서드 비밀번호 체크에 매개변수로 입력한 비밀번호와 uesr 정보를 넣어준다.
				return null; //비밀번호가 맞지 않아서 false라면 리턴값이 없다.
			}
		}
		return user; //user 속에 값이 null이면 바로 user 변수를 리턴한다.
	}
}
