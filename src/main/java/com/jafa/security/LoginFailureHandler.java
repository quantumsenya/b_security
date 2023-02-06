package com.jafa.security;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
public class LoginFailureHandler implements AuthenticationFailureHandler {

	private String errorMessage; // 에러메세지
	private String defaultFailureUrl; // 로그인 실패시 이동할 url

	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.info("로그인실패");
		
		String loginId = request.getParameter("loginId"); 
		
		if(exception instanceof BadCredentialsException) {
			errorMessage = "아이디 또는 비밀번호가 일치하지 않습니다.";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "아이디 또는 비밀번호가 일치하지 않습니다.";
		} else {
			errorMessage = "알수없는 오류입니다. 관리자에게 문의하세요.";
		}
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("loginId", loginId);
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}

}
