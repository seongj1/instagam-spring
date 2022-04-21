package com.instagram.app.domain.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	@Autowired
	private SqlSession session; //DB와 연결하는 객체를 @Autowired로 가져온다.
	
	@Override
	public int checkUsername(String username) { //session에서 보내준 1 또는 0 값을 int 자료형으로 리턴한다.
		return session.selectOne("com.instagram.app.domain.user.UserRepository.checkUsername", username); 
	}
	
//	@Override
//	public int checkname(String name) {
//		return session.selectOne("com.instagram.app.domain.user.UserRepository.checkname", name);
//	}
}
