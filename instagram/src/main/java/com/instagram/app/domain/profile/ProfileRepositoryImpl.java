package com.instagram.app.domain.profile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class ProfileRepositoryImpl implements ProfileRepository{
	@Autowired
	private SqlSession session; //DB와 연결하는 객체를 @Autowired로 가져온다.
	
	
	private final String NAME_SPACE = "com.instagram.app.domain.profile.ProfileRepository.";
	
	@Override
	public Account getAccountProfileByUsercode(int usercode) {
		return session.selectOne(NAME_SPACE + "getAccountProfileByUsercode", usercode);
	}
}
