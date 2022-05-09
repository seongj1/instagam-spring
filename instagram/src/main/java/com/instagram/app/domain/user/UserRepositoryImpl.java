package com.instagram.app.domain.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class UserRepositoryImpl implements UserRepository{
	@Autowired
	private SqlSession session; //DB와 연결하는 객체를 @Autowired로 가져온다.
	
	
	private final String NAME_SPACE = "com.instagram.app.domain.user.UserRepository.";
	
	@Override
	public int checkUsername(String username) { //username를 session으로 전달하는 메서드
		return session.selectOne(NAME_SPACE + "checkUsername", username); //session에 select 할때 주소와 username을 넣고 int 자료형으로 리턴한다.
	}
	
//	@Override
//	public int checkname(String name) {
//		return session.selectOne("com.instagram.app.domain.user.UserRepository.checkname", name);
//	}
	
	@Override
	public int signup(User user) { // User 객체를 session으로 전달하는 메서드
		return session.insert(NAME_SPACE + "signup", user); // session에 insert할 때 쓰는 주소와 user객체를 넣고 int 자료형으로 리턴한다.
	}
	
	@Override
	public User getUserByUsername(String username) { //username을 매개변수로 받아서 User 객체를 생성해서 username을 찾아준다
		return session.selectOne(NAME_SPACE + "getUserByUsernames", username); //user 객체를 생성해서 session에다가 넣어주고 리턴
	}
}
