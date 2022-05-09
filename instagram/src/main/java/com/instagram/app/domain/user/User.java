package com.instagram.app.domain.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User { //데이터베이스의 컬럼 명들이랑 모두 같게 써야 한다.
	private int usercode;
	private String phone;
	private String email;
	private String name;
	private String username;
	private String password;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
