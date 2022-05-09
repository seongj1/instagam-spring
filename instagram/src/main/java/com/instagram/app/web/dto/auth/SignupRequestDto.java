package com.instagram.app.web.dto.auth;

import org.mindrot.jbcrypt.BCrypt;

import com.instagram.app.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupRequestDto { // form 데이터를 받아서 넘겨줄 변수들 설정
	private String phoneOrEmail;
	private String name;
	private String username;
	private String password;
	
	public User toEntity() { //변수들에 데이터들을 바로 생성해서 보내주는 역할
		String phone = null;
		String email = null;
		if(phoneOrEmail.contains("@")) { //전화번호와 이메일을 구분 짓는 if문
			email = phoneOrEmail; // 골뱅이가 있다면 email변수로 넣고
		}else {
			phone = phoneOrEmail; // 골뱅이가 없다면 phone변수로 넣는다.
		}
		return User.builder()
				.phone(phone)
				.email(email)
				.name(name)
				.username(username)
				.password(BCrypt.hashpw(password, BCrypt.gensalt()))  // 비밀번호를 암호화 시켜서 데이터베이스에 저장해주는 기능 BCrypt
				.build();
	}
}
