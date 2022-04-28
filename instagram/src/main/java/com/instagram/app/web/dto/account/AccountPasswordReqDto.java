package com.instagram.app.web.dto.account;

import com.instagram.app.domain.profile.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountPasswordReqDto {
	
	public String password;
	
	public Account toEntity() {
		return Account.builder()
				.password(password)
				.build();
	}
}
