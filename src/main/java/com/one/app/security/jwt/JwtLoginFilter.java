package com.one.app.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter{
	
	
	private JwtTokenManager jwtTokenManager;
	
	private AuthenticationManager authenticationManager;
	
	
	
	
	
	
	//login 요청을 처리 
	
	public JwtLoginFilter(AuthenticationManager authenticationManager,JwtTokenManager jwtTokenManager) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenManager = jwtTokenManager;
		this.setFilterProcessesUrl("users/login");
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		log.info("Login 시도");
		String username = request.getParameter("username");
		String passowrd = request.getParameter("password");
		
		UsernamePasswordAuthenticationToken authenticationToken;
		authenticationToken = new UsernamePasswordAuthenticationToken(username,passowrd);
		
		Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
				
		
		return authentication;
	}
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("authResult : {}",authResult);
		
		response.sendRedirect("/");
		//Token 생성하고 Client로 전송
		String token = jwtTokenManager.createToken(authResult);
		log.info("Token : {}", token);
		
		Cookie cookie = new Cookie("accessToken", token);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
	}
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("Fail : {}", failed);
		//로그인이 실패 했을 때 실행 
		
		response.sendRedirect("/users/login");
	
	}

	
	
	
	
}
