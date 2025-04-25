package com.one.app.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserSocialService extends DefaultOAuth2UserService{

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// TODO Auto-generated method stub
		
		log.info("Tocken :{}",userRequest.getAccessToken());
		ClientRegistration registration = userRequest.getClientRegistration();
		log.info("ID : {}", registration.getRegistrationId());
		
		String sns = registration.getRegistrationId();
		
		if(sns.toUpperCase().equals("KAKAO")) {
			return this.useKaKao(userRequest);
			
		}
		
		
		
		return null;	
	}

	private OAuth2User useKaKao(OAuth2UserRequest userRequest){
		
		//ID로 DB에서 조회 
		
		
		
		
		OAuth2User user = super.loadUser(userRequest);
		log.info("User :{}",user);
		log.info("name :{}",user.getName());
		log.info("Attr :{}",user.getAttributes());
		log.info("auth :{}",user.getAuthorities());
		
		log.info("prop :{}", user.getAttributes().get("properties").getClass());
		
		Map<String, Object> attr = (Map<String, Object>)user.getAttributes().get("properties");
		
		UserVO userVO = new UserVO();
		
		userVO.setAttributes(user.getAttributes());
		userVO.setUsername(attr.get("nickname").toString());
		userVO.setFileName(attr.get("thumbnail_image").toString());
		
		userVO.setAccessToken(userRequest.getAccessToken().getTokenValue());
		
		userVO.setSns(userRequest.getClientRegistration().getRegistrationId());
		
	
		List<RoleVO> list = new ArrayList<>();
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleName("ROLE_MEMBER");
		
		list.add(roleVO);
		userVO.setList(list);
		
		
		return userVO;
	}
	
	
	
}
