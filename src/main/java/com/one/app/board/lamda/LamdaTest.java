package com.one.app.board.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class LamdaTest {
	
	
	
	public void test3() {
		
		
		Supplier<List<String>> s = ()->{
			
			
			String [] n = {"a","b","c"};
			List<String> ar = Arrays.asList(n);
		
			return ar;
		};
		
		List<String> ar = s.get();
		
		
		
	}
	
	
	
	 public void test2() {
	 
	 Test3Interface t3 = (List<Object> ar)->{
		 System.out.println("test");
	 };
	 t3.t1(null);
		 
	  //interface에 두개 이상의 메서드가 있는 경우 //Lamda 사용 X Test2Interface t2 = (int n1)->{
	 
	  
	 
	 
}
	
	
	
	
	
	
	
	public void test() {
		TestInterface t = new Plus();
		t.cal(10, 20);
		
		t = new Minus();
		t.cal(10, 20);
		
		
		t = (int n1, int n2) -> n1+n2;
		int result = t.cal(10, 20);
		
		t=(int n1, int n2) ->{
			return n1*n2;
		};
		result = t.cal(1, 2);
		
		
	}

}
