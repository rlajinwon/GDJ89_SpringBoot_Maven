package com.one.app.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.one.app.user.UserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class SecurityLogoutSuccessHandler implements LogoutSuccessHandler{
	
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
	private String adminKey;
	
	
	
	
	
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
	
	
	
	private void kakaoLogout(UserVO userVO) {
		log.info("admin : {}", adminKey);
		
		
		
		
		//Admin key사용시 Parameter 설정 
		Map<String, Object> map = new HashMap<>();
		map.put("target_id_type", "user_id");
		map.put("target_id", userVO.getAttributes().get("id"));
		
		
		WebClient webClient = WebClient.create();
		Mono<String> res = webClient
				
			.post() //메서드 형식 
			.uri("https://kapi.kakao.com/v1/user/logout")
//			 .header("Authorization", "Bearer" + userVO.getAccessToken())
			.header("Authorization", "KaKaoAK " + adminKey)
			.bodyValue(map)
			 .retrieve()
			 .bodyToMono(String.class)
			 ;
		
		log.info("Result {}",res.block());
										
	}

}
