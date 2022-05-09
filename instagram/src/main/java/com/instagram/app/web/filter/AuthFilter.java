package com.instagram.app.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.instagram.app.config.FileConfig;
import com.instagram.app.domain.user.User;

@Component
public class AuthFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		FileConfig.profileImgPath = filterConfig.getServletContext().getRealPath("/static/fileupload");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		HttpSession session = httpServletRequest.getSession();
		User user = (User)session.getAttribute("principal"); //session에 있는 principal 객체를 불러와서 user 변수 안에 저장
		
		String path = httpServletRequest.getRequestURI(); // 요청주소를 담아줄 path 변수 생성
		
		if(path.contains("/app/auth")){  // path가 "/app/auth"를 포함하고 있으면
			if(user != null) { // user 값이 null이 아니라면 
				httpServletResponse.sendRedirect("/app/"); // index 페이지로 보내라
				return;
			}
		}else if(path.contains("/app/static")) { // path에 /app/static 이 있으면 (이것은 그냥 지나가는 기능)
			
		}else {
			if(user == null) { //user 값이 null이라면
				httpServletResponse.sendRedirect("/app/auth/signin"); // signin 페이지로 보내서 로그인하게 만들어라
				return;
			}
		}
		
		chain.doFilter(httpServletRequest, httpServletResponse); //filter가 실행될 때 메서드 
		
	}

	@Override
	public void destroy() {
		
	}

}