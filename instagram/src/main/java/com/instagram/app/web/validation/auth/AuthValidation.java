package com.instagram.app.web.validation.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthValidation {
	public Map<Boolean, String> isNull(String name, String value){ //null 값을 체크하는 메서드
		Map<Boolean, String> result = new HashMap<Boolean, String>(); //Map객체 생성
		if(value == null) {  //value가 null 일때 
			result.put(true, name + "의 값이 비어있습니다.");
			return result;
		}else if(value.replace(" ", "").equals("")) { //value의 값이 비어 있을 때
			result.put(true, name + "의 값이 비어있습니다.");
			return result; 
		}
		return null;
	}
}
