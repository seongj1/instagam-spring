package com.instagram.app.auth;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.domain.profile.ProfileImg;
import com.instagram.app.domain.profile.ProfileRepository;
import com.instagram.app.domain.user.User;
import com.instagram.app.domain.user.UserRepository;

@Service
public class PrincipalServiceImpl implements PrincipalService{
	
	@Autowired //자동으로 객체 생성해주는 어노테이션
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	
	@Override
	public User loadUserByUsername(String username) { //username을 매개변수로 받아서 찾은 다음 userRepository에 넣어서 리턴하는 메서드
		return userRepository.getUserByUsername(username); // userRepository에서 메서드를 불러와 실행 
		
	}
	
	@Override
	public boolean passwordCheck(String password, User user) { // 입력한 password와 데이터베이스의 password를 비교하는 메서드
		if(BCrypt.checkpw(password, user.getPassword())) { //새로 입력한 password와 데이터베이스에서 password를 가져와서 비교했을 때
			return true; // 맞으면 true를 리턴
		}else {
			return false; // 틀리면 false를 리턴
		}
	}
	
	@Override
	public ProfileImg getProfileImg(int usercode) {
		return profileRepository.getProfileImg(usercode);
	}
}
