package com.instagram.app.web.util.auth;

public class AuthResponseScript {
	public String signupScript(boolean result) { // 회원가입이 완료되었다는 것을 알려줄 html파일 메서드
		StringBuilder script = new StringBuilder();
		
		if(result) { //result가 true인지 false인지에 따라 달라지는 if문
			script.append("<script>");
			script.append("alert(\"회원가입 완료.\");"); // 회원가입 완료됐다는 알림창
			script.append("location.replace(\"/app/auth/signin\");"); // 회원가입이 된 후에 signin 창으로 보내준다.
			script.append("</script>");
		}else { // result가 false일 때 
			script.append("<script>");
			script.append("alert(\"회원가입 실패.\");"); // 회원가입에 실패 했다는 알림창
			script.append("history.back();"); // 뒤로가기를 실행해서 다시 회원가입 창으로 보내준다.
			script.append("</script>");
		}
		
		return script.toString();
	}
	
	public String signinValidScript(String msg) { // 벨리데이션 알림창 띄워줄 script 메서드 
		StringBuilder script = new StringBuilder();
		
		script.append("<script>");
		script.append("alert(\"" + msg + "\");"); // 알림 메세지 띄워주기
		script.append("location.replace(\"/app/auth/signin\");"); // 로그인 페이지로 다시 보내기 
		script.append("</script>");
		
		return script.toString(); // script 안에 값을 문자열로 리턴하기 
	}
}
