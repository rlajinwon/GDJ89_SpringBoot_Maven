package com.one.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.one.app.user.UserService;

@Configuration
@EnableWebSecurity //(debug = true)
public class SecurityConfig {
	
	
	@Autowired
	private SecurityLoginSuccessHandler loginSuccessHandler;
	@Autowired
	private SecurityLoginFailHandler loginFailHandler;
	@Autowired
	private UserService userService;
	
	
	
	

	//정적 자원들은 security에서 제외 

	@Bean
	WebSecurityCustomizer customizer() {
	//WebSecurityCustomizer s = ()->{}
	//return s;
		return (web)->{
			web.ignoring()
				.requestMatchers("/css/**")
				.requestMatchers("/images/**","/img/**")
				.requestMatchers("/js/**")
				.requestMatchers("/vendor/**");
		};
		
	}

	// 인증과 권한에 관한 설정 
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
	
		httpSecurity
					// CORS 허용, Filter에서도 사용 가능 
					.cors(cors-> cors.disable())
					.csrf(csrf-> csrf.disable())	
					
					// 권한 적용 
					.authorizeHttpRequests(authorizeRequest->{
						authorizeRequest.requestMatchers("/notice/add","/notice/update","/notice/delete").hasRole("ADMIN")
						.requestMatchers("/users/mypage","/users/update","users/logout").authenticated()
						.requestMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER")
						.anyRequest().permitAll();
					})
					
					// Form 관련 설정 
					
					.formLogin(formlogin ->{
						formlogin.loginPage("/users/login")
						.defaultSuccessUrl("/")
						.failureUrl("/users/login")
						.permitAll();
					})
					
					// Logout 관련 설정 
					.logout(logout ->{
						logout
						.logoutUrl("/users/logout")
						.logoutSuccessUrl("/")
						.invalidateHttpSession(true)
						.permitAll();
					})
					
					.rememberMe(rememberme->{
						rememberme
						.rememberMeParameter("remember-me")
						.tokenValiditySeconds(60)
						.key("rememberkey")
						.userDetailsService(userService)
						.authenticationSuccessHandler(loginSuccessHandler)
						.useSecureCookie(false);
					})
					.sessionManagement(s->{
						s
						.sessionFixation().newSession()//.changeSessionId()
						
						.invalidSessionUrl("/")
						.maximumSessions(1)
						.maxSessionsPreventsLogin(false)
						.expiredUrl("/user/login")
						;
						
					})
					
					
					;
					
		return httpSecurity.build();
		
	}
	
	
	
	
	
}
