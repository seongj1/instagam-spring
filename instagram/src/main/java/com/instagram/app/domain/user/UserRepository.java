package com.instagram.app.domain.user;

public interface UserRepository {
	public int checkUsername(String username);
//	public int checkname(String name);
	public int signup(User user);
	public User getUserByUsername(String username);
}
