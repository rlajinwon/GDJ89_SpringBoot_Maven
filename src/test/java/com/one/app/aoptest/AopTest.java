package com.one.app.aoptest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AopTest {
	
	@Autowired
	private Card card;
	
	@Autowired
	private Transport transport;
		
		
		@Test
		void test() throws Exception{
		
			String res = transport.getBus(10);
			
			String res2 = transport.getSubway("blue");
			
			
			
			transport.walk();
			
			
			String res3 = transport.bicyle(1000);
			
			System.out.println("=====================");
			System.out.println(res);
			System.out.println(res2);
			System.out.println(res3);
			
			System.out.println("종료");
		
		}		

}
