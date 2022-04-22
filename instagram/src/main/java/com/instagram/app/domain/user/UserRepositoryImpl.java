package com.instagram.app.domain.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	@Autowired
	private SqlSession session; //DB와 연결하는 객체를 @Autowired로 가져온다.
	
	
	private final String NAME_SPACE = "com.instagram.app.domain.user.UserRepository.";
	
	@Override
	public int checkUsername(String username) { //session에서 보내준 1 또는 0 값을 int 자료형으로 리턴한다.
		return session.selectOne(NAME_SPACE + "checkUsername", username); 
	}
	
//	@Override
//	public int checkname(String name) {
//		return session.selectOne("com.instagram.app.domain.user.UserRepository.checkname", name);
//	}
	
	@Override
	public int signup(User user) {
		return session.insert(NAME_SPACE + "signup", user);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return session.selectOne(NAME_SPACE + "getUserByUsernames", username);
	}
}
