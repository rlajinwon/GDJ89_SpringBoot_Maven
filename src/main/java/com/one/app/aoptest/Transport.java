package com.one.app.aoptest;

import org.springframework.stereotype.Component;

@Component
public class Transport {

	
	
	public String getBus(int num) throws Exception{
		System.out.println("bus");
		return "Bus";
	}
	
	public String getSubway(String name) {
		System.out.println("지하철");
		return "Subway";
	}
	
	
	public void walk() {
		System.out.println("걸어서");
	}
	
	public String bicyle(int money) {
		
		System.out.println("자전거 사용");
		return "Seoul";
		
	}
	
	
}
