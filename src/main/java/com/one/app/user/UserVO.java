package com.one.app.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UserVO implements UserDetails, OAuth2User {



	@NotBlank(message = "ID는 필수입력")
	private String username;
	@Size(min = 8, max = 16)
	@NotBlank(message = "PW는 필수입력")
	private String password;
	private String passwordCheck;
	private String name;
	private String phone;
	//@Range(min = 0, max = 150)
	//private int age;
	@Email
	private String email;
	@Past
	@NotNull
	private Date birth;
	private String fileName;
	private String oriName;
	
	private List<RoleVO> list;
	
	// oau2user 
	private Map<String, Object> attributes;
	
	private String accessToken;
	
	private String sns;
	
	
	
	
	
	
	
	
	
	// oau2user

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//ROLE_NAME를 리턴 
		
		
		List<GrantedAuthority> ar = new ArrayList<>();
		
		for(RoleVO roleVO:this.list) {
			GrantedAuthority g = new SimpleGrantedAuthority(roleVO.getRoleName());
			ar.add(g);
			
		}
		return ar;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	
	
	
	
	
}
