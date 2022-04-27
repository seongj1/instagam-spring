package com.instagram.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.domain.profile.Account;
import com.instagram.app.domain.profile.ProfileRepository;
import com.instagram.app.domain.user.UserRepository;
import com.instagram.app.web.dto.account.AccountResponseDto;
import com.instagram.app.web.dto.account.AccountupdateReqDto;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public AccountResponseDto getAccountProfile(int usercode) {
		return profileRepository.getAccountProfileByUsercode(usercode).toDto();
	}
	
	@Override
	public boolean updateAccount(AccountupdateReqDto accountupdateReqDto) {
		if(userRepository.checkUsername(accountupdateReqDto.getUsername()) != 0) {
			return false;
		}
		
		profileRepository.updateUserMst(accountupdateReqDto.toEntity());
		profileRepository.updateUserDtl(accountupdateReqDto.toEntity());
		return true;
	}
}
