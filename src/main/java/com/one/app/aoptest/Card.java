package com.one.app.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // 어떤 어드바이스를 어떤 point-cut에 언제 실행 할 것인가를 설정 
public class Card {
	
	@Before("execution( * com.one.app.aoptest.Transport.bicyle(*))")
	public void userMobile(JoinPoint joinPoint) {
		System.out.println("앱 결제");
		System.out.println(joinPoint.getArgs());
		
		
	}
	
	
	
	
	
	
	
	@Around("execution( * com.one.app.aoptest.Transport.get*(*))")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("탑승 전 Card check");	
		/*
		 * System.out.println(joinPoint.getKind());
		 * System.out.println(joinPoint.getTarget());
		 */
		 Object [] ar= joinPoint.getArgs();
		 
		 for(Object obj : ar) {
			 System.out.println("Args : "+ obj.toString());
		 }
		 
		 
		Object obj = joinPoint.proceed();
		System.out.println(obj.toString());
		System.out.println("하차 시 Card check");
		
		String result = "OK";
		
		return result;
	}
	

}
