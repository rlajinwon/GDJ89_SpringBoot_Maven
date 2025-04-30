package com.one.app.security.jwt;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtTokenManager {
	
	
	private SecretKey key;
	
	@Value("${jwt.secretKey}")
	private String jwtSecretKey;
	

	@Value("${jwt.accessToken.ValidTime}")
	private long accessTokenValidTime;
	
	@Value("${jwt.issuer}")
	private String issuer;
	
	@PostConstruct // 생성자에서도 사용 가능 
	public void init() {
		String s = Base64.getEncoder().encodeToString(jwtSecretKey.getBytes());
		this.key = Keys.hmacShaKeyFor(s.getBytes());
		
	}
	
	
	/** 
	 * Token 생성 
	 * (로그인이 성공했을때) 
	 * **/
	
	public String createToken(Authentication authentication) {
		
		return Jwts 
			.builder()
			.setSubject(authentication.getName()) //사용자의 아이디
			//개발자가 추가 정보를 넣고싶을때
			.claim("roles", authentication.getAuthorities())
			.setIssuedAt(new Date(System.currentTimeMillis()))//Token 발급 시간
			.setExpiration(new Date(System.currentTimeMillis()+accessTokenValidTime))
			.setIssuer(issuer) // Token 발급자
			.signWith(key)
			.compact()
			;
			
	
	}
	
	
	
	
}
